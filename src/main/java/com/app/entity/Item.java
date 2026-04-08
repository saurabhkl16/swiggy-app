package com.app.entity;

import com.app.util.IdGenerator;

public class Item {
    private int id;
    private String name;
    private String description;
    private double price;
    private boolean available;

    public Item(String name, String description, double price, boolean available) {
        this.id = IdGenerator.getItemIdCounter();
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format("Item{id=%d, name='%s', price=%.2f, available=%b}",
                id, name, price, available);
    }
}
