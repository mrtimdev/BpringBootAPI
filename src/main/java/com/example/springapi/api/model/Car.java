package com.example.springapi.api.model;

public class Car {
    private String name;
    private int wheels;

    // Constructors, getters, and setters
    public Car(String name, int wheels) {
        this.name = name;
        this.wheels = wheels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}
