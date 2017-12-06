package com.javarush.task.task25.task2512;

/* 
Живем своим умом
В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений, начиная с самого вложенного.

Пример исключения:
new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))

Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        if (e.getCause() != null) uncaughtException(t, e.getCause());
        System.out.println((e.getClass()+ ": " + e.getMessage()));
    }

    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                try {
                    throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
                } catch (Exception e) {
                    getUncaughtExceptionHandler().uncaughtException(currentThread(), e);
                }
            }
        };
        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();
    }
}
