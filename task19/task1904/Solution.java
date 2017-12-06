package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

/*
И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner. Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные только одного человека.
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;
        PersonScannerAdapter(Scanner fileScanner){
        this.fileScanner = fileScanner;
        }
        @Override
        public Person read() throws IOException {
            FileReader fileReader = new FileReader("d:/kol.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String s = reader.readLine();
            String[] strings = s.split(" ");
            System.out.println(strings);
            Calendar calendar = new Calendar.Builder().build();
            calendar.set(Integer.parseInt(strings[5]), Integer.parseInt(strings[3]) ,Integer.parseInt(strings[4]));
            return new Person(strings[0],strings[1],strings[2],calendar.getTime());
        }

        @Override
        public void close() throws IOException {
fileScanner.close();
        }
    }
}
