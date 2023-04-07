package com.zoo.service;

import com.zoo.model.Animal;
import com.zoo.model.BigAnimal;
import com.zoo.model.Bird;
import com.zoo.model.Cat;
import com.zoo.model.Zoo;
import com.zoo.consolApp.App;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalService {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int START_RANGE = 1;
    private static int END_RANGE = 3;

    public static void getAllAnimals(Zoo zoo) {
        if (!Zoo.isZooCreated()) {
            System.out.println("Please create a zoo first.");
            return;
        }

        if (zoo.getAnimalList().isEmpty()) {
            System.out.println("There are no animals in the zoo.");
            return;
        }
        System.out.println(zoo.getAnimalList());
    }

    public static void addAnimal(Zoo zoo) {

        if (!Zoo.isZooCreated()) {
            System.out.println("Please create a zoo first.");
            return;
        }

        System.out.println("What kind of animal would you like to add?");
        System.out.println("1. Bird");
        System.out.println("2. Cat");
        System.out.println("3. Big animal");

        int choice = 0;
        try {
            choice = Integer.valueOf(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Hey, what are you doing? It`s not number!");
        }
        App.validRange(START_RANGE, END_RANGE, choice);
        switch (choice) {
            case 1:
                BirdService.addBird(zoo);
                break;
            case 2:
                CatService.addCat(zoo);
                break;
            case 3:
                BigAnimalService.addBigAnimal(zoo);
                break;
        }
    }

    @SneakyThrows
    public static void getSpecificAnimal(Zoo zoo) {
        if (!Zoo.isZooCreated()) {
            System.out.println("Please create a zoo first.");
            return;
        }
        System.out.println("What is animal`s name? ");
        String name = reader.readLine();
        List<Animal> animalList = zoo.getAnimalList();

        if (zoo.getAnimalList().isEmpty()) {
            System.out.println("There are no animals in the zoo.");
            return;
        }
        List findAnimalList = animalList.stream().filter(x -> x.getName().equals(name)).collect(Collectors.toList());
        if ( findAnimalList.isEmpty()) {
            System.out.println("Animal with name "+ name +" doesn`t exist");
        }
        else findAnimalList.stream().forEach(System.out::println);
    }

    public static void getAnimalByViews(Zoo zoo) {

        if (!Zoo.isZooCreated()) {
            System.out.println("Please create a zoo first.");
            return;
        }

        System.out.println("Choice the type of animal to view");
        System.out.println("1. Bird");
        System.out.println("2. Cat");
        System.out.println("3. Big animal");

        int choice = 0;
        try {
            choice = Integer.valueOf(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Hey, what are you doing? It`s not number!");
        }
        App.validRange(START_RANGE, END_RANGE, choice);
        switch (choice) {
            case 1:
                checkAviableViews(Bird.class, zoo.getAnimalList());
                break;
            case 2:
                checkAviableViews(Cat.class, zoo.getAnimalList());
                break;
            case 3:
                checkAviableViews(BigAnimal.class, zoo.getAnimalList());
                break;
        }
    }
    private static void checkAviableViews(Class clazz, List<Animal> list){
        List<Animal> temp = list.stream().filter(x -> x.getClass().equals(clazz)).collect(Collectors.toList());
        if (temp.isEmpty() || temp == null){
            System.out.println("These animals have not yet been add to the zoo");
        }
        else list.stream().filter(x -> x.getClass().equals(clazz)).forEach(System.out::println);
    }
}