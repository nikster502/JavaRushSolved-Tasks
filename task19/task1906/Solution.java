package com.javarush.task.task19.task1906;

/* 
Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример:
второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());


        while (fileReader.ready()){
            int i = fileReader.read();
            int v = fileReader.read();

                fileWriter.write(v);

        }
        fileReader.close();
        fileWriter.close();
        reader.close();
    }
}
