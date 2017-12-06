package com.javarush.task.task19.task1926;

/* 
Перевертыши
1 Считать с консоли имя файла. Считать содержимое файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке.
2.2 вывести на экран.
3 Закрыть потоки.

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        while (file.ready()){
            String  s = file.readLine();
            StringBuffer stringBuffer = new StringBuffer(s);
            System.out.println(stringBuffer.reverse());
        }
file.close();
    }
}
