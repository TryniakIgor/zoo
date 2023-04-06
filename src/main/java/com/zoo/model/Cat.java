package com.zoo.model;

import lombok.Data;

@Data
public class Cat extends Animal {
    private long id;
    private static int count = 0;

    public Cat(String name, String from) {
      super(name, from);
      this.id = count++;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", from='" + getFrom() + '\'' +
                '}';
    }
}
