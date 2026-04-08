package com.app.util;

public class IdGenerator {
    private static int userIdCounter = 0;
    private static int itemIdCounter = 5000;
    private static int restIdCounter = 10000;

    // Private constructor (utility class)
    private IdGenerator() {
    }

    // Generate Student ID
    public static synchronized int getUserIdCounter() {
        return userIdCounter++;
    }

    public static synchronized int getItemIdCounter() {
        return itemIdCounter++;
    }

    public static synchronized int getRestIdCounter() {
        return restIdCounter++;
    }
}
