package com.example;

public class Main {
    public static void main(String[] args) {

        Engine sportEngine = new Engine("V8", 650);

        Car sportsCar = new Car.Builder("Ferrari SF90")
                .seats(2)
                .engine(sportEngine)
                .color("Red")
                .gps(true)
                .tripComputer(true)
                .build();

        Engine ecoEngine = new Engine("Hybrid I4", 190);

        Car familyCar = new Car.Builder("Toyota Prius")
                .seats(5)
                .engine(ecoEngine)
                .color("Silver")
                .gps(true)
                .build(); 

        System.out.println(sportsCar);
        System.out.println(familyCar);
    }
}
