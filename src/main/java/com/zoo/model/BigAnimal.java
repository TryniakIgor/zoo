package com.zoo.model;

import lombok.Data;

@Data
public class BigAnimal extends Animal {
    private long id;
    private static int count = 0;

    public BigAnimal(String name, String from) {
        super(name, from);
        this.id = count++;
    }

    @Override
    public String toString() {
        return "BigAnimal{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", from='" + getFrom() + '\'' +
                '}';
    }
}
