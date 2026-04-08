package com.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static int idCounter = 10000;
    private int id;
    private String menuType;
    private List<Item> items = new ArrayList<>();

    public Menu(String menuType) {
        this.id = ++idCounter;
        this.menuType = menuType;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(int itemId) {
        items.removeIf(item -> item.getId() == itemId);
    }

    public int getId() { return id; }
    public String getName() { return menuType; }
    public List<Item> getItems() { return items; }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + menuType + '\'' +
                ", items=" + items +
                '}';
    }
}
