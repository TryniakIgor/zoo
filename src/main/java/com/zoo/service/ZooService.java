package com.zoo.service;

import com.zoo.model.Zoo;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZooService {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Zoo zoo;

    @SneakyThrows
    public static void createZoo() {

        if (Zoo.isZooCreated()) {
            System.out.println("You already created Zoo");
            return;
        }
        System.out.println("What would you like to name your zoo?");

        String name = reader.readLine();
        if (name == null || name.isEmpty()) {
            System.out.println("Name can not be empty");
            createZoo();
        }

        zoo = Zoo.getInstance(name);
        System.out.println("Zoo " + name + " created successfully!");

    }

    public static Zoo getZoo() {
        return zoo;
    }
}
