package com.javarush.task.task29.task2909.car;

/**
 * Created by nik on 13.07.2017.
 */
public class Truck extends Car {
    public Truck(int numberOfPassengers) {
        super(Car.TRUCK, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_TRUCK_SPEED = 80;
   return MAX_TRUCK_SPEED;
    }
}
