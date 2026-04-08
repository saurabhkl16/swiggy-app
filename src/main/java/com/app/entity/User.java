package com.app.entity;

import com.app.util.IdGenerator;

public class User {
    private int user_id;
    private String name;
    private String mobile;
    private String address;

    public User(String name,String mobile,String address){
        this.user_id = IdGenerator.getUserIdCounter();
        this.name = name;
        this.mobile = mobile;
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', mobile='%s'}",
                user_id, name, mobile);
    }
}
