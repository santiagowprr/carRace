package com.codecool.car_race;

public class Car extends Vehicle {

    public Car() {
        super(generateCarName(), generateNormalSpeed());
    }

    public static int generateNormalSpeed() {
        return (int) (Math.random() * (110 - 80) + 80);
    }

    public static String generateCarName() {
        String[] carNames = {"Might", "Quicksilver", "Onyx", "Nmbus", "Albatross", "Mystery", "Reach", "Legacy", "Harmony", "Inquiry"};
        return carNames[(int) Math.floor(Math.random() * (carNames.length))] + " " + carNames[(int) Math.floor(Math.random() * (carNames.length))];
    }

    public void yellowFlagActivated() {
        setActualSpeed(75);
    }

    public void yellowFlagNotActive() {
        setActualSpeed(getNormalSpeed());
    }
}
