package com.javarush.task.task19.task1925;

/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина rr которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file1 =new BufferedReader(new FileReader(args[0] ));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> list = new ArrayList<>();
while (file1.ready()){
    String[] strings = file1.readLine().split(" ");
    for (String s : strings){
        if (s.length()>6){
            list.add(s);
            list.add(",");
        }
    }
}
file1.close();
for (int i=0;i<list.size()-1;i++){
    file2.write(list.get(i));
}
file2.close();
    }
}
