package com.example;

public class Car {
    private final int seats;
    private final Engine engine;
    private final boolean hasGPS;
    private final boolean hasTripComputer;
    private final String color;
    private final String model;

    private Car(Builder builder) {
        this.seats = builder.seats;
        this.engine = builder.engine;
        this.hasGPS = builder.hasGPS;
        this.hasTripComputer = builder.hasTripComputer;
        this.color = builder.color;
        this.model = builder.model;
    }


    public int getSeats() { return seats; }
    public Engine getEngine() { return engine; }
    public boolean hasGPS() { return hasGPS; }
    public boolean hasTripComputer() { return hasTripComputer; }
    public String getColor() { return color; }
    public String getModel() { return model; }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", seats=" + seats +
                ", engine=" + engine +
                ", color='" + color + '\'' +
                ", gps=" + hasGPS +
                ", tripComputer=" + hasTripComputer +
                '}';
    }


    public static class Builder {

        private final String model;

        private int seats = 4;
        private Engine engine = new Engine("V6", 250);
        private boolean hasGPS = false;
        private boolean hasTripComputer = false;
        private String color = "White";


        public Builder(String model) {
            this.model = model;
        }

        public Builder seats(int seats) {
            this.seats = seats;
            return this;
        }

        public Builder engine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder gps(boolean hasGPS) {
            this.hasGPS = hasGPS;
            return this;
        }

        public Builder tripComputer(boolean hasTripComputer) {
            this.hasTripComputer = hasTripComputer;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            validate();
            return new Car(this);
        }

        private void validate() {
            if (model == null || model.trim().isEmpty()) {
                throw new IllegalArgumentException("Car model is required.");
            }
            if (engine == null) {
                throw new IllegalArgumentException("Engine cannot be null.");
            }
        }
    }
}