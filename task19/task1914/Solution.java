package com.javarush.task.task19.task1914;

/* 
Решаем пример
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.

Возможные операции: + — *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов — нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(byteArrayOutputStream);

        System.setOut(stream);

        testString.printSomething();
        String result = byteArrayOutputStream.toString();

        System.setOut(printStream);

        StringBuilder stringBuilder = new StringBuilder(result);
        String reverseString = stringBuilder.toString();

        System.out.print(reverseString);

        Pattern p = Pattern.compile("(\\d+)\\s?([-+*])\\s?(\\d+)\\s?[=]\\s?"+System.getProperty("line.separator"));

        Matcher m = p.matcher(result);
        m.matches();

       if (m.group(2).equals("+")){
            int i = Integer.parseInt(m.group(1));
            int j = Integer.parseInt(m.group(3));
            System.out.println(i+j);
        }
        if (m.group(2).equals("*")){
            int i = Integer.parseInt(m.group(1));
            int j = Integer.parseInt(m.group(3));
            System.out.println(i*j);
        }
        if (m.group(2).equals("-")){
            int i = Integer.parseInt(m.group(1));
            int j = Integer.parseInt(m.group(3));
            System.out.println(i-j);
        }

    }
    public static class TestString {
        public void printSomething() {

            System.out.println("3 + 6 = ");
        }
    }
}

