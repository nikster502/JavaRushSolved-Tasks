package com.javarush.task.task21.task2113;
/*
Теперь вернемся к методу print класса Horse.

Т.к. мы работаем с консолью, то все лошади на бегах будут выглядеть примерно так:
........Sleven <- лошадь Слевин
....Lucky <- лошадь Лаки
..........Gomer <- лошадь Гомер

Другими словами, в методе print надо вывести на экран строку состоящую из точек и имени лошади.
Количество точек равно distance, округленному (в меньшую сторону) до целого числа.
*/

public class Horse {
    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    String name;
    double speed;
    double distance;
    Horse(String name,double speed){
        this.name = name;
        this.speed = speed;
        this.distance = 100/speed;
    }

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
    public void print(){
        for (int i = 0; i < (int)getDistance(); i++)
        {
            System.out.print(".");
        }
        System.out.println(getName());
    }
    public void move(){
        distance+=speed*Math.random()*1;
    }
}
