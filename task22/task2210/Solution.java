package com.javarush.task.task22.task2210;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.

Пример
getTokens("level22.lesson13.task01", ".")

Возвращает
{"level22", "lesson13", "task01"}
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getTokens("level22.lesson13.task01", "."));
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);

        ArrayList<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
           list.add(tokenizer.nextToken());
        }
        String[] s = new String[list.size()];
        int i=0;
        for (String l : list){
            s[i++]=l;
        }

        return s;
    }
}
