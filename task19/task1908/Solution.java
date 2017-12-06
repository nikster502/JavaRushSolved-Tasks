package com.javarush.task.task19.task1908;

/*
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.
Пример тела файла:
12 text var2 14 8v 1
Результат:
12 14 1
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();
        while (fileReader.ready()){
            String s = fileReader.readLine();
            for (String interval : s.split(" "))
          if (isNumber(interval)){
              fileWriter.write(interval+" ");
          }
        }
        fileReader.close();
        fileWriter.close();
    }
    public  static boolean isNumber(String c){
        try {
            Double.parseDouble(String.valueOf(c));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
