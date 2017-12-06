package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.

d:/java/copy.txt
d:/java/copy1.txt
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        BufferedReader fileR2 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader fileR1 = new BufferedReader(new FileReader(s));

        ArrayList<Integer> list = new ArrayList<>();

        while(fileR1.ready()){
          list.add(fileR1.read());
        }
        BufferedWriter fileW1 = new BufferedWriter(new FileWriter(s));
        while (fileR2.ready()){
            fileW1.write(fileR2.read());
        }
        for (int i=0;i<list.size();i++){
            fileW1.write(list.get(i));
        }
        fileR2.close();
        fileR1.close();
        fileW1.close();
        reader.close();
    }
}
