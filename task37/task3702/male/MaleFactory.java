package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * Created by nik on 29.11.2017.
 */
public class MaleFactory implements AbstractFactory {
    public Human getPerson(int age) {

        if (age > 0 && age <= KidBoy.MAX_AGE) {
            return new KidBoy();
        } else if (age > 0 && age <= TeenBoy.MAX_AGE) {
            return new TeenBoy();
        } else
            return new Man();


    }
}
