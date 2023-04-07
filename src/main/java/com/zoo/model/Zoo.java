package com.zoo.model;


import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Zoo {
    private static Zoo instance;
    public List<Animal> animalList = new ArrayList<>();
    private String name;

    private Zoo(String name) {
        this.name = name;
    }

    public static Zoo getInstance(String name) {
        if (instance == null) {
            instance = new Zoo(name);
        }
        return instance;
    }

    public static boolean isZooCreated() {
        return instance != null;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }
}


