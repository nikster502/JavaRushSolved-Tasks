package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
В методе main подмени объект System.out написанной тобой реадер-оберткой.
Твоя реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Рекламный текст: «JavaRush — курсы Java онлайн»

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream byteArrayOutputStreams = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(byteArrayOutputStreams);
        System.setOut(stream);

        testString.printSomething();

        String result = byteArrayOutputStreams.toString();

        System.setOut(console);
        int count =0;
        for (String s : result.split("\n")){
            System.out.println(s);

            if (count==1){
                System.out.println("JavaRush - курсы Java онлайн");
                count=-1;
            }
            count++;

        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
