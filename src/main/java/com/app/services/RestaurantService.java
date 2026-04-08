package com.app.services;

import com.app.entity.Item;
import com.app.entity.Menu;
import com.app.entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private List<Restaurant> restList = new ArrayList<>();

    public void addRestaurant(Restaurant restaurant) {
        restList.add(restaurant);
    }

    public List<Restaurant> getRestaurantList() {
        for (Restaurant r : restList) {
            System.out.println(r);
        }
        return restList;
    }

    public void addDummyRestauList() {
        Menu gulabo_menu = new Menu("Veg");
        Item vada_pav = new Item("Vada pav", "Very testy", 10, true);
        Item cold_coffe = new Item("Cold Coffe", "Sweet and cold", 100, true);
        gulabo_menu.addItem(vada_pav);
        gulabo_menu.addItem(cold_coffe);

        Restaurant gulabo = new Restaurant("Gulabo", "dsf dffdf fddf", gulabo_menu);
        System.out.println(gulabo);
    }
}