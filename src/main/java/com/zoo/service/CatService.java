package com.zoo.service;

import com.zoo.model.Animal;
import com.zoo.model.Cat;
import com.zoo.model.Zoo;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CatService {

    @SneakyThrows
    public static void addCat(Zoo zoo) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is the cat's name?");
        String name = reader.readLine();
        System.out.println("Where from " + name + " ? ");
        String from = reader.readLine();
        Animal cat = new Cat(name, from);
        zoo.addAnimal(cat);
        System.out.println(name + " added successfully!");
    }
}
