package com.zoo.service;

import com.zoo.model.Animal;
import com.zoo.model.BigAnimal;
import com.zoo.model.Zoo;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BigAnimalService {
    @SneakyThrows
    public static void addBigAnimal(Zoo zoo) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is the animal's name?");
        String name = reader.readLine();
        System.out.println("Where from " + name + " ? ");
        String from = reader.readLine();
        Animal bigAnimal = new BigAnimal(name, from);
        zoo.addAnimal(bigAnimal);
        System.out.println(name + " added successfully!");
    }
}
