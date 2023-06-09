package com.zoo.consolApp;

import com.zoo.model.User;
import com.zoo.model.Zoo;
import com.zoo.service.AnimalService;
import com.zoo.service.UserService;
import com.zoo.service.ZooService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Zoo zoo;
    private static User user;
    private static int START_RANGE = 1;
    private static int END_RANGE = 5;



    public static void start() {
        System.out.println("Welcome to the Zoo App!");
        UserService.auhtorization();
        user = UserService.getUser();

        while (true) {
            System.out.println("Hello " + user.getName() + ", what would you like to do today?");
            System.out.println("1. Create a new zoo");
            System.out.println("2. Add an animal to the zoo");
            System.out.println("3. View all animals in the zoo");
            System.out.println("4. Find specific animal by name");
            System.out.println("5. Navigate cross the views");
            System.out.println("6. Exit");

            int choice = 0;
            try {
                choice = Integer.valueOf(reader.readLine());
                validRange(START_RANGE, END_RANGE, choice);
            } catch (IOException e) {
                e.printStackTrace();

            } catch (NumberFormatException e) {
                System.out.println("Hey, what are you doing? It`s not number!");
            }
            switch (choice) {
                case 1:
                    ZooService.createZoo();
                    zoo = ZooService.getZoo();
                    user.setZoo(zoo);
                    break;
                case 2:
                    AnimalService.addAnimal(zoo);
                    break;
                case 3:
                    AnimalService.getAllAnimals(zoo);
                    break;
                case 4:
                    AnimalService.getSpecificAnimal(zoo);
                    break;
                case 5:
                    AnimalService.getAnimalByViews(zoo);
                    break;
                case 6:
                    System.out.println("Bye!");
                    return;
            }
        }
    }

    public static void validRange(int start, int finish, int current) {
        if (current < start || current > finish) {
            System.out.println("Please make your choice with correct number");
        }
    }
}
