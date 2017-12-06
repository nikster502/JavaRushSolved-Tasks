package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
1. Разберись, что делает программа.
2. Реализуй логику метода run так, чтобы каждую секунду через пробел
выдавался отсчет начиная с countSeconds до 1, а потом слово [Марш!] (см примеры).
3. Если нить работает 3.5 секунды или более, прерви ее методом interrupt и внутри нити выведи в консоль слово [Прервано!].

Пример для countSeconds=4 :
«4 3 2 1 Прервано!»

4. Если нить работает менее 3.5 секунд, она должна завершиться сама.
Пример для countSeconds=3 :
«3 2 1 Марш!»

PS: метод sleep выбрасывает InterruptedException.
*/

import java.util.Date;

public class Solution {
    public static volatile int countSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        RacingClock clock = new RacingClock();
        clock.join();
        Date date1 = new Date();
Thread.sleep(3500);
        if (date1.getSeconds()-date.getSeconds()<3.5){
            System.out.println("Марш!");
        }
        else {
            System.out.println("Прервано!");


        }
        clock.interrupt();
        //add your code here - добавь код тут
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {

            Thread current = Thread.currentThread();
            while (!current.isInterrupted())
                if (countSeconds>=1){
                    System.out.print(countSeconds-- +" ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else break;
            }


            //add your code here - добавь код тут
        }
    }

