package com.zoo.service;

import com.zoo.model.User;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserService {
    private static User user;

    @SneakyThrows
    public static void auhtorization() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is your name? ");
        String name = reader.readLine();
        if (name == null || name.isEmpty()) {
            System.out.println("Name can not be empty");
            auhtorization();
        }
        user = new User(name);
    }

    public static User getUser() {
        return user;
    }
}
