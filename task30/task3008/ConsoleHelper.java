package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by nik on 16.07.2017.
 */
public class ConsoleHelper {
   private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString(){
        String message="";
        while (true) {
            try {
                message = reader.readLine();
                return message;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }

    }
    public static int readInt() {
        while (true) {
            try {
                int i = Integer.parseInt(readString());
                return i;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
    }
}
