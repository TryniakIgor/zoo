package com.zoo.model;

import lombok.Data;

@Data
public class User {
    private String name;
    private Zoo zoo;

    public User(String name) {
        this.name = name;
    }
}
