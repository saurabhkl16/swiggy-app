package com.app.services;

import com.app.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users= new ArrayList<>();


    public void addUser(User user){
        users.add(user);
        System.out.println("User Created.");
    }

    public void userList(){
        for(User u : users){
            System.out.println(u);
        }
    }
}
