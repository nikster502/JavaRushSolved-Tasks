package com.javarush.task.task21.task2113;

/*
Добавим определение победителя.
В классе Hippodrome сделаем два метода:
public Horse getWinner() и public void printWinner()

Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
Метод printWinner выводит на экран имя победителя в виде: Winner is <name>!
        */

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
Hippodrome(List<Horse> horses){
    this.horses  = horses;
}
public  Horse getWinner(){
    double i =0;
    Horse horse=null;
    for (Horse h : horses){
        if (i<h.distance){
            i = h.distance;
            horse = h;
        }
    }
    return horse;
}
public void printWinner(){
    System.out.println("Winner is "+ getWinner().getName()+"!");
}
    private   List<Horse> horses = new ArrayList<>();

    public List<Horse> getHorses()
    {
        return horses;
    }

    static Hippodrome game;
public void run() throws InterruptedException {
    for (int i=0;i<100;i++) {
        move();
        print();
        Thread.sleep(200);
    }
}
    public void move(){
        for (Horse h : getHorses()) {
            h.move();
        }
    }
    public void print(){
        for (Horse h : getHorses()) {
            h.print();
        }
        for (int i=0;i<10;i++){
            System.out.println();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        List<Horse> list = new ArrayList<>();
        list.add(new Horse("Nikita",3,0));
        list.add(new Horse("kol",3,0));
        list.add(new Horse("Na",3,0));
game = new Hippodrome(list);

game.run();
        game.printWinner();
    }
}
