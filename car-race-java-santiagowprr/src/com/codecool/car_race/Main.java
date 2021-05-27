package com.codecool.car_race;


import com.sun.source.tree.TryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Scanner scanner = new Scanner(System.in);

    /**
     * Creates all the vehicles that will be part of this race.
     */
    private static void createVehicles(Race race) {
        // GENERATE PARTICIPANTS:
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();
        Car car8 = new Car();
        Car car9 = new Car();
        Car car10 = new Car();

        Car[] cars = {car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};


        Motorcycle motorcycle1 = new Motorcycle();
        Motorcycle motorcycle2 = new Motorcycle();
        Motorcycle motorcycle3 = new Motorcycle();
        Motorcycle motorcycle4 = new Motorcycle();
        Motorcycle motorcycle5 = new Motorcycle();
        Motorcycle motorcycle6 = new Motorcycle();
        Motorcycle motorcycle7 = new Motorcycle();
        Motorcycle motorcycle8 = new Motorcycle();
        Motorcycle motorcycle9 = new Motorcycle();
        Motorcycle motorcycle10 = new Motorcycle();

        Motorcycle[] motorcycles = {motorcycle1, motorcycle2, motorcycle3, motorcycle4, motorcycle5, motorcycle6, motorcycle7, motorcycle8, motorcycle9, motorcycle10};


        Truck truck1 = new Truck();
        Truck truck2 = new Truck();
        Truck truck3 = new Truck();
        Truck truck4 = new Truck();
        Truck truck5 = new Truck();
        Truck truck6 = new Truck();
        Truck truck7 = new Truck();
        Truck truck8 = new Truck();
        Truck truck9 = new Truck();
        Truck truck10 = new Truck();

        Truck[] trucks = {truck1, truck2, truck3, truck4, truck5, truck6, truck7, truck8, truck9, truck10};


        race.registerCars(cars);
        race.registerMotorcycles(motorcycles);
        race.registerTrucks(trucks);


    }

    /**
     * Entry point of our program. Creates one race instance and
     * uses that.
     * <p>
     *
     * @param args commandline arguments passed to the program.
     *             It is unused.
     */
    public static void main(String[] args) {

        // GENERATE RACE:
        Race race = new Race();
        createVehicles(race);
        race.simulateRace();

    }
}
