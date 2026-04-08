package com.app.entity;

import com.app.util.IdGenerator;

public class Restaurant {
    private int rest_id;
    private String name;
    private String address;
    private Menu menu;

    public Restaurant(String name, String address,Menu menu){
        this.rest_id = IdGenerator.getRestIdCounter();
        this.name = name;
        this.address = address;
        this.menu = menu;
    }

    public int getRest_id() {
        return rest_id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Menu getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                ", Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", " + menu +
                '}';
    }
}
