package com.javarush.task.task05.task0515;

/* 
Инициализация объектов
Изучи внимательно класс Person.
Исправь класс так, чтобы только один метод initialize инициализировал все переменные класса Person.
*/

public class Person {
    String name;
    char sex;
    int money;
    int weight;
    double size;

    public void initialize(String name, int money, char sex, int weigh,double size) {
        this.name = name;
        this.money = money;
        this.sex = sex;
        this.weight =weigh;
        this.size =size;
    }

    public static void main(String[] args) {

    }
}
