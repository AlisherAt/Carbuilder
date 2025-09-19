package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Engine sportEngine = new Engine("V8", 650);
        Engine ecoEngine = new Engine("Hybrid I4", 190);

        Car sportsCar = new Car.Builder("Ferrari SF90")
                .seats(2)
                .engine(sportEngine)
                .color("Red")
                .gps(true)
                .tripComputer(true)
                .build();

        Car familyCar = new Car.Builder("Toyota Prius")
                .seats(5)
                .engine(ecoEngine)
                .color("Silver")
                .gps(true)
                .build();

        System.out.println(sportsCar);
        System.out.println(familyCar);
        System.out.println();

        System.out.print("Would you like to build your own car? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (choice.equals("yes") || choice.equals("y")) {
            try {
                Car customCar = buildCarFromUserInput(scanner);
                System.out.println("\n✅ Your Custom Car:");
                System.out.println(customCar);
            } catch (IllegalArgumentException e) {
                System.err.println("❌ Error building your car: " + e.getMessage());
            }
        } else {
            System.out.println("Okay! Maybe next time.");
        }

        scanner.close();
    }

    private static Car buildCarFromUserInput(Scanner scanner) {
        System.out.print("Enter car model: ");
        String model = scanner.nextLine();
        if (model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty.");
        }

        System.out.print("Enter number of seats: ");
        int seats;
        try {
            seats = Integer.parseInt(scanner.nextLine().trim());
            if (seats <= 0) {
                throw new IllegalArgumentException("Seats must be positive.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number of seats.");
        }

        System.out.print("Enter engine type (e.g., V6, Electric): ");
        String engineType = scanner.nextLine();

        System.out.print("Enter engine horsepower: ");
        double horsepower;
        try {
            horsepower = Double.parseDouble(scanner.nextLine().trim());
            if (horsepower < 0) {
                throw new IllegalArgumentException("Horsepower cannot be negative.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid horsepower value.");
        }
        Engine engine = new Engine(engineType, horsepower);

        System.out.print("Does it have GPS? (true/false): ");
        boolean hasGPS = Boolean.parseBoolean(scanner.nextLine().trim());

        System.out.print("Does it have Trip Computer? (true/false): ");
        boolean hasTripComputer = Boolean.parseBoolean(scanner.nextLine().trim());

        System.out.print("Enter car color: ");
        String color = scanner.nextLine();

        return new Car.Builder(model)
                .seats(seats)
                .engine(engine)
                .color(color)
                .gps(hasGPS)
                .tripComputer(hasTripComputer)
                .build();
    }
}
