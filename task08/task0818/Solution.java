package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: «фамилия» — «зарплата».
Удалить из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
   static HashMap<String,Integer> map = new HashMap<>();
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код

        map.put("Nikita0",10000);
        map.put("Nikita1",100);
        map.put("Nikita2",5000);
        map.put("Nikita3",500);
        map.put("Nikita4",300);
        map.put("Nikita5",4000);
        map.put("Nikita6",400);
        map.put("Nikita7",1200);
        map.put("Nikita8",100);
        map.put("Nikita9",1100);
        return  map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String,Integer> copy = new HashMap<>(map);
         for (Map.Entry<String, Integer> pair : copy.entrySet()) {

            if (pair.getValue()< 500) {
               map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
removeItemFromMap(createMap());

    }
}