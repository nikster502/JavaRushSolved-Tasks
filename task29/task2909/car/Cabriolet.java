package com.javarush.task.task29.task2909.car;

/**
 * Created by nik on 13.07.2017.
 */
public class Cabriolet extends Car {
    public Cabriolet( int numberOfPassengers) {
        super(Car.CABRIOLET, numberOfPassengers);
    }
    @Override
    public int getMaxSpeed() {
        final int MAX_SEDAN_SPEED = 90;
        return MAX_SEDAN_SPEED;
    }
}
