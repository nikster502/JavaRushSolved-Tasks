package com.javarush.task.task19.task1907;
/*
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов «world«, которые встречаются в файле.
Закрыть потоки.
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String s;
        int count=0 ;
        while (fileReader.ready()){
            s = fileReader.readLine();
            for (String v : s.split("[^\\w]")) {
                  if (v.equals("world"))
                        count++;
            }

        }

        System.out.println(count);
        fileReader.close();
    }
}
