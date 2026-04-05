package com.app;

import com.app.constants.AppConstants;
import com.app.entity.User;
import com.app.services.UserService;

import java.util.Scanner;

class Main {
    private static Scanner sc = new Scanner(System.in);
    private static UserService us = new UserService();
    private static boolean exit = false;

    public static void main(String[] args) {
        while (!exit) {
            System.out.println(AppConstants.MAIN_MENU);
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter mobile number: ");
                    String mobile = sc.nextLine();

                    System.out.print("Enter your full address: ");
                    String address = sc.nextLine();

                    User user = new User(name, mobile, address);
                    us.addUser(user);
                }
                case 2 -> {
                    loginMenu();
                }
                case 3 -> {
                    System.out.println("Work in progress.Comming Soon....");
                }
                case 0 -> {
                    System.out.println("Thanks for visit");
                    exit = true;
                }
                default -> {
                    System.out.println("Invalid choice!");
                }
            }

        }
    }

    private static void loginMenu() {
        boolean loginExit = false;

        while(!loginExit){
            System.out.println(AppConstants.LOGIN_MENU);
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1 -> {
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter mobile number: ");
                    String mobile = sc.nextLine();

                    System.out.println("Login Success..!");
                }
                case 2 -> us.userList();
                case 3 -> {
                    System.out.println("Returning to Main Menu...");
                    loginExit = true; // exit login menu loop
                }
                case 0 -> {
                    System.out.println("Thanks for visit");
                    exit = true;      // exit main menu too
                    loginExit = true;  // exit login menu
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}