package com.javarush.task.task01.task0140;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
Выводим квадрат числа
Напиши программу, которая считывает с клавиатуры целое число a и выводит квадрат этого числа (a * a).
Внимательно просмотри лекцию. Для считывания данных с клавиатуры используй метод nextInt() класса Scanner.
Выводим квадрат числа
*/

public class Solution {
    public static void main(String[] args) {
        int a;
       Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        System.out.println(a*a);

    }
}