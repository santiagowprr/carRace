package com.codecool.car_race;

import java.util.Scanner;


public class Race {
    private Car[] cars = null;
    private Motorcycle[] motorcycles = null;
    private Truck[] trucks = null;
    private int hoursLeft = 50;
    private boolean isYellowFlagActive = false;
    private boolean isRaining = false;

    public Race() {
    }

    public Car[] getCars() {
        return cars;
    }

    public Motorcycle[] getMotorcycles() {
        return motorcycles;
    }

    public Truck[] getTrucks() {
        return trucks;
    }


    public boolean checkIfTrucksBroken() {
        int brokenTrucks = 0;
        for (Truck truck : getTrucks()) {
            if (truck.isBroken()) {
                brokenTrucks++;
                System.out.println(truck.getName() + " is still broken. He travelled " + truck.getDistanceTraveled() + " and his actual speed is " + truck.getActualSpeed());
            } else if (truck.isTruckBroken()) {
                brokenTrucks++;
                truck.setBrokenTime(2); // the truck will be broken for 2 hours
                System.out.println(truck.getName() + " broke down!! He travelled " + truck.getDistanceTraveled() + " and his actual speed is " + truck.getActualSpeed());
            } else {
                System.out.println(truck.getName() + " is not broken. He travelled " + truck.getDistanceTraveled() + " and his actual speed is " + truck.getActualSpeed());
            }
        }
        if (brokenTrucks > 0) {
            System.out.println("There are " + brokenTrucks + " broken truck(s)!");
            System.out.println("Cars ride at 75 Km!");
            setYellowFlagActive(true);
            return true;
        } else {
            setYellowFlagActive(false);
            return false;
        }
    }

    /**
     * Simulates the passing of time by advancing the weather and
     * moving the vehicles for the duration of a whole race.
     */

    private void moveParticipants() {
        for (Car car : getCars()) {
            car.moveForAnHour();
        }
        for (Motorcycle motorcycle : getMotorcycles()) {
            motorcycle.moveForAnHour();
        }
        for (Truck truck : getTrucks()) {
            truck.moveForAnHour();
        }
    }

    private void advance() {
        // The advance() method sets the weather with 30% chance to rain
        double precipitation = Math.floor(Math.random() * 10 + 1);
        isRaining = precipitation > 7;
    }

    private void adjustMotorcycleSpeed(boolean isRaining) {
        if (isRaining) {
            System.out.println("It is raining! The motorcycles need to slow down!");
            for (Motorcycle motorcycle : getMotorcycles()) {
                motorcycle.slowDownItRains();
            }
        } else {
            System.out.println("It's not raining, motorcycles go normally 100 KM");
            for (Motorcycle motorcycle : getMotorcycles()) {
                motorcycle.setActualSpeed(motorcycle.getNormalSpeed());
            }
        }
    }

    /**
     * Prints the state of all vehicles. Called at the end of the
     * race.
     */
    public void printRaceResults() {
        //Prints each vehicle's name, distance traveled, and type
        for (Car car : getCars()) {
            System.out.println("The car " + car.getName() + " travelled " + car.getDistanceTraveled() + " KM!");
        }


        System.out.println("++++++++++++++++++++++++++++++++");

        for (Motorcycle motorcycle : getMotorcycles()) {
            System.out.println("The motorcycle " + motorcycle.getName() + " travelled " + motorcycle.getDistanceTraveled() + " KM!");
        }
        System.out.println("++++++++++++++++++++++++++++++++");


        for (Truck truck : getTrucks()) {
            System.out.println("The truck " + truck.getName() + " travelled " + truck.getDistanceTraveled() + " KM!");
        }
        System.out.println("++++++++++++++++++++++++++++++++");

    }


    //  REGISTER RACERS
    public void registerCars(Car[] carRacers) {
        cars = carRacers;
    }

    public void registerMotorcycles(Motorcycle[] motorcycleRacers) {
        motorcycles = motorcycleRacers;
    }

    public void registerTrucks(Truck[] truckRacers) {
        trucks = truckRacers;
    }

    public void anHourPassed() {
        hoursLeft--;
    }

    public void adjustCarSpeed(boolean isYellowFlagActive) {
        if (isYellowFlagActive) {  // if yellowflag atcive set actualspeed to 75, otherwise access a car and get his normal speed
            for (Car car : getCars()) {
                car.yellowFlagActivated();
            }
        } else {
            for (Car car : getCars()) {
                car.yellowFlagNotActive();
            }
        }
    }

    public void setYellowFlagActive(boolean yellowFlagActive) {
        isYellowFlagActive = yellowFlagActive;
    }

    public void simulateRace() {
        Scanner scanner = new Scanner(System.in);
        int hourOfRace = 1;

        while (hoursLeft > 0) {

            advance(); // checks if it rains
            adjustMotorcycleSpeed(isRaining);  // if it rains motorcycles slow down, otherwise they go at normal speed
            checkIfTrucksBroken();  // checks if theres any broken truck, if there is, yellow flag is on + thie broken truck has actualspeed = 0
            adjustCarSpeed(isYellowFlagActive); // if yellow flag, cars slow down, otherwise they go at normal speed
            prepareAllTrucksForLap();

            moveParticipants();
            anHourPassed();
            printRaceResults();  // lap results
            System.out.println("--------------HOUR " + hourOfRace + "-------------");
            hourOfRace++;
//            scanner.nextLine();
        }
        printRaceResults();   // final results
    }

    private void prepareAllTrucksForLap() {
        for (Truck truck : getTrucks()) {
            truck.prepareTruckForLap();
        }
    }
}