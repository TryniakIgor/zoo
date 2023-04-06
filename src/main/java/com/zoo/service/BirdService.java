package com.zoo.service;

import com.zoo.model.Animal;
import com.zoo.model.Bird;
import com.zoo.model.Zoo;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BirdService {

    @SneakyThrows
    public static void addBird(Zoo zoo) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is the bird's name?");
        String name = reader.readLine();
        System.out.println("Where from " + name + " ? ");
        String from = reader.readLine();
        Animal bird = new Bird(name, from);
        System.out.println(bird);
        zoo.addAnimal(bird);
        System.out.println(name + " added successfully!");
    }
}
