package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]));

        while (file.ready()){
            String[] s = file.readLine().split(" ");
            for (String string : s){
                char[] chars = string.toCharArray();
                for (char c : chars){
                    if (isNumber(c)){
                        file2.write(string+" ");
                        break;
                    }
                }
            }

        }
        file.close();
        file2.close();

    }
    public static boolean isNumber(char c){
        try {
            int i = Integer.parseInt(String.valueOf(c));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
