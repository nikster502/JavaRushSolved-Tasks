package com.javarush.task.task19.task1920;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        Map<String,Double> map = new TreeMap<>();
        String s ;
        while ((s = file.readLine())!=null){
         String[] v = s.split(" ");
           if (map.containsKey(v[0])){
               map.put(v[0], map.get(v[0]) + Double.parseDouble(v[1]));
           }
           else {
               map.put(v[0], Double.parseDouble(v[1]));
           }
        }
        Double max=null;
        for (String k : map.keySet()) {
            max = map.get(k);
            for (String l : map.keySet()) {
                    if (max <= map.get(l)) {

                        max = map.get(l);
                    }

            }
        }

        for (String key : map.keySet()){
            if (max.equals(map.get(key))){
                System.out.println(key);
            }
        }

        file.close();
        }

    }

