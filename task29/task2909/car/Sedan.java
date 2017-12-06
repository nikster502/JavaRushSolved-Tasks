package com.javarush.task.task29.task2909.car;

/**
 * Created by nik on 13.07.2017.
 */
public class Sedan extends Car {
    public Sedan(int numberOfPassengers) {
        super(Car.SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_TRUCK_SPEED = 120;
        return MAX_TRUCK_SPEED;
    }
}
