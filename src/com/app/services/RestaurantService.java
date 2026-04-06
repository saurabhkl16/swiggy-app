package com.app.services;

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
}
