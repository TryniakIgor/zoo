package com.zoo.service;

import com.zoo.model.Zoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZooService {
private static Zoo zoo;

    public static Zoo  createZoo() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (Zoo.isZooCreated()) {
            System.out.println("You already created Zoo");
            return zoo;
        }
        System.out.println("What would you like to name your zoo?");
        String name = null;
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        zoo = Zoo.getInstance(name);
        System.out.println("Zoo " + name + " created successfully!");
        return zoo;
    }
}
