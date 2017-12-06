package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Map;
import java.util.TreeMap;


public class Solution {
   static Map<String,Double> map = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        reader.close();
        String s ;
        while ((s = file.readLine())!=null) {
            String[] v = s.split(" ");
            if (map.containsKey(v[0])) {
                        map.put(v[0], map.get(v[0]) + Double.parseDouble(v[1]));

            }
            else {
                map.put(v[0], Double.parseDouble(v[1]));
            }
        }
        for (String m : map.keySet()){
            System.out.println(m+ " "+ map.get(m));
        }
        file.close();
    }
}
