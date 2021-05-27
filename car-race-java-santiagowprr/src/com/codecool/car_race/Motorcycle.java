package com.codecool.car_race;

public class Motorcycle extends Vehicle {
    private static int IdCounter = 0;

    public Motorcycle() {
        super(generateName(), 100);
        IdCounter = IdCounter;
    }

    public static String generateName() {
        return "Motorcycle " + getIdCounter();
    }

    public static int getIdCounter() {
        IdCounter++;
        return IdCounter;
    }

    public void slowDownItRains() {
        int slowDownValue = (int) (Math.random() * (50 - 5) + 5);
        this.setActualSpeed(getActualSpeed() - slowDownValue);
    }
}
