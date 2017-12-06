package com.javarush.task.task18.task1826;

/* 
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName — имя файла, который необходимо зашифровать/расшифровать.
fileOutputName — имя файла, куда необходимо записать результат шифрования/дешифрования.
-e — ключ указывает, что необходимо зашифровать данные.
-d — ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.
-e e:/1.txt e:/2.txt
-d e:/2.txt e:/1.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {


      FileInputStream read = new FileInputStream(args[1]);
      FileOutputStream writer = new FileOutputStream(args[2]);
        StringBuilder sb1 = new StringBuilder();
        if (args[0].equals("-e")){
            while (read.available() > 0) {
                char c = (char) read.read();
                sb1.append(c);
            }
            String s1 = String.valueOf(sb1.reverse());
            writer.write(s1.getBytes());
        }
        else if(args[0].equals("-d")){
            while (read.available() > 0) {
                char c = (char) read.read();
                sb1.append(c);
        }
            String s1 = String.valueOf(sb1.reverse());
            writer.write(s1.getBytes());

    }
        read.close();
        writer.close();
}}
