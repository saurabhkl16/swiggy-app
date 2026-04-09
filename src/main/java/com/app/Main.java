package com.app;

import com.app.controller.LoginHandler;
import com.app.controller.RestaurantHandler;
import com.app.controller.SignupHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/signup", new SignupHandler());
            server.createContext("/login", new LoginHandler());
            server.createContext("/restaurants", new RestaurantHandler());
            server.setExecutor(null);
            server.start();
            System.out.println("Server started on http://localhost:8080/signup");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


//        while (!exit) {
//            System.out.println(AppConstants.MAIN_MENU);
//            System.out.print("Enter your choice: ");
//            int choice = sc.nextInt();
//            sc.nextLine();
//
//            switch (choice) {
//                case 1 -> {
//                    System.out.print("Enter your name: ");
//                    String name = sc.nextLine();
//
//                    System.out.print("Enter mobile number: ");
//                    String mobile = sc.nextLine();
//
//                    System.out.print("Enter your full address: ");
//                    String address = sc.nextLine();
//
//                    User user = new User(name, mobile, address);
//                    us.addUser(user);
//                }
//                case 2 -> {
//                    loginMenu();
//                }
//                case 3 -> {
//                    System.out.println("Work in progress.Comming Soon....");
//                }
//                case 0 -> {
//                    System.out.println("Thanks for visit");
//                    exit = true;
//                }
//                default -> {
//                    System.out.println("Invalid choice!");
//                }
//            }
//
//        }
//    }
//
//    private static void loginMenu() {
//        boolean loginExit = false;
//
//        while (!loginExit) {
//            System.out.println(AppConstants.LOGIN_MENU);
//            System.out.print("Enter your choice: ");
//            int choice = Integer.parseInt(sc.nextLine());
//
//            switch (choice) {
//                case 1 -> {
//                    System.out.print("Enter your name: ");
//                    String name = sc.nextLine();
//
//                    System.out.print("Enter mobile number: ");
//                    String mobile = sc.nextLine();
//
//                    System.out.println("Login Success..!");
//                }
//                case 2 -> us.userList();
//                case 3 -> {
//                    System.out.println("Returning to Main Menu...");
//                    loginExit = true; // exit login menu loop
//                }
//                case 0 -> {
//                    System.out.println("Thanks for visit");
//                    exit = true;      // exit main menu too
//                    loginExit = true;  // exit login menu
//                }
//                default -> System.out.println("Invalid choice!");
//            }
//        }
//    }
//}