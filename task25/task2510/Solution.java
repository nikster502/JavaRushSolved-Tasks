package com.javarush.task.task25.task2510;

import java.io.IOException;

/*
Поживем - увидим
Все исключения, которые возникают в процессе работы нити Solution, должны быть обработаны одним из вариантов:
1. Если это Error, то вывести в консоль «Нельзя дальше работать«.
2. Если это Exception, то вывести в консоль «Надо обработать«.
3. Если это Throwable, то вывести в консоль «ХЗ«.
Реализуй эту логику.


Требования:
1. В конструкторе Solution должен wустанавливаться свой UncaughtExceptionHandler, который будет перехватывать возникшие ошибки и выводить текст в консоль.
2. Если выполнение нити Solution закончилось исключением Error, нужно вывести в консоль "Нельзя дальше работать".
3. Если выполнение нити Solution закончилось исключением Exception, нужно вывести в консоль "Надо обработать".
4. Если выполнение нити Solution закончилось исключением Throwable, нужно вывести в консоль "ХЗ".
*/
public class Solution extends Thread{

    public Solution() {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Error)
                    System.out.println("Нельзя дальше работать");
                else if (e instanceof Exception)
                    System.out.println("Надо обработать");
                else if (e instanceof  Throwable)
                    System.out.println("ХЗ");
            }
        });
    }

    public static void main(String[] args) throws IOException {

    }



}
