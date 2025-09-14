package com.example;


public class Engine {
    private final String type;
    private final double horsepower;

    public Engine(String type, double horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return horsepower + " HP " + type;
    }
}