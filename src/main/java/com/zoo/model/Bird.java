package com.zoo.model;
import lombok.Data;

@Data
public class Bird extends Animal {
    private long id;
    private static int count = 0;

    public Bird(String name, String from) {
        super(name, from);
        this.id = count++;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", from='" + getFrom() + '\'' +
                '}';
    }
}
