package com.javarush.task.task23.task2307;

/* 
Как выбрать нужное?
В методе main присвой объекту Object obj экземпляр класса TEST.
Не изменяй ничего кроме метода main.
*/
public class Solution {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {
        Solution.TEST test = new Solution.TEST();
        obj = test;

        System.out.println(obj);
    }
}
