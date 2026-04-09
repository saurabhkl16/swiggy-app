package com.app.controller;

import com.app.util.Database;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignupHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Always add CORS headers
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "http://localhost:4200");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

        // Handle preflight OPTIONS request
        if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(200, -1); // no body
            return;
        }

        if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            exchange.sendResponseHeaders(405, -1); // Method Not Allowed
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);

            JSONObject json = new JSONObject(sb.toString());
            String name = json.getString("name");
            String mobile = json.getString("mobile");
            String password = json.getString("password");

            // 1️⃣ Check if mobile contains only digits
            if (!mobile.matches("\\d+")) {
                String response = "{\"message\":\"Mobile number must contain only digits\"}";
                exchange.getResponseHeaders().add("Content-Type", "application/json");
                exchange.sendResponseHeaders(400, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
                return;
            }

            int result = saveUser(name, mobile, password);

            String response;
            int status;
            if (result == 1) { // signup successful
                response = "{\"message\":\"Signup successful\"}";
                status = 200;
            } else if (result == 0) { // mobile already exists
                response = "{\"message\":\"Mobile number already registered\"}";
                status = 400; // Bad Request
            } else { // other error
                response = "{\"message\":\"Signup failed\"}";
                status = 500;
            }

            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(status, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
            exchange.sendResponseHeaders(500, -1);
        }
    }

    private int saveUser(String name, String mobile, String password) {
        String checkSql = "SELECT COUNT(*) AS count FROM users WHERE mobile = ?";
        String insertSql = "INSERT INTO users (name, mobile, password) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection()) {

            // 1️⃣ Check if mobile exists
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setString(1, mobile);

                // Execute query
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt("count"); // get count from column alias
                        if (count > 0) {
                            return 0; // mobile already exists
                        }
                    }
                }
            }

            // 2️⃣ Insert new user
            try (PreparedStatement stmt = conn.prepareStatement(insertSql)) {
                stmt.setString(1, name);
                stmt.setString(2, mobile);
                stmt.setString(3, password);
                stmt.executeUpdate();
                return 1; // success
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // error
        }
    }
}