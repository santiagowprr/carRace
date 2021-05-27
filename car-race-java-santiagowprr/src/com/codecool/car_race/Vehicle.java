package com.codecool.car_race;

public class Vehicle {
    private final String name;
    private int distanceTraveled;
    private int actualSpeed;
    private int normalSpeed;

    public Vehicle(String name, int normalSpeed) {
        this.name = name;
        this.distanceTraveled = 0;
        this.actualSpeed = 100;
        this.normalSpeed = normalSpeed;
    }

    public String getName() {
        return name;
    }

    public int getNormalSpeed() {
        return normalSpeed;
    }

    public int getActualSpeed() {
        return actualSpeed;
    }

    //setter:
    public void moveForAnHour() {
        this.distanceTraveled += this.getActualSpeed();
    }

    public void setActualSpeed(int actualSpeed) {
        this.actualSpeed = actualSpeed;
    }

    public void prepareVehicleForLap(int newLapSpeed) {
        this.actualSpeed = newLapSpeed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }
}
