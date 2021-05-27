package com.codecool.car_race;

public class Truck extends Vehicle {
    private boolean isBroken;
    private int brokenTime;

    public Truck() {
        super(generateName(), 100);
        isBroken = false;
        brokenTime = 0;
    }

    public static String generateName() {
        return String.valueOf((int) Math.floor(Math.random() * 1000));
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public void prepareTruckForLap() {
        if (this.brokenTime == 0) {
            setBroken(false);
        }
        if (isBroken()) {
            super.prepareVehicleForLap(0);
            brokenTime--;
        } else {
            prepareVehicleForLap(getNormalSpeed());
        }
    }


    public boolean isTruckBroken() {
        //Trucks have a 5% chance of breaking down for 2 hours
        int truckState = (int) Math.floor(Math.random() * 20) + 1;
        return truckState == 20;
    }

    public void setBrokenTime(int brokenTimeToSet) {
        this.brokenTime = brokenTimeToSet;
        setBroken(true);
    }
}
