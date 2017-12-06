package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
Класс Solution будет использоваться трэдами.
Реализуй логику всех методов, используйте класс ThreadLocalRandom.
getRandomIntegerBetweenNumbers должен возвращать случайный int между from и to.
getRandomDouble должен возвращать случайный double.
getRandomLongBetween0AndN должен возвращать случайный long между 0 и n.


Требования:
1. В классе Solution должны быть только статические методы.
2. Метод getRandomIntegerBetweenNumbers с помощью ThreadLocalRandom должен возвращать случайный int между from и to.
3. Метод getRandomDouble с помощью ThreadLocalRandom должен возвращать случайный double от 0 до 1.
4. Метод getRandomLongBetween0AndN с помощью ThreadLocalRandom должен возвращать случайный long между 0 и n.
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from,to);
    }

    public static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        return ThreadLocalRandom.current().nextLong(0,n);
    }

    public static void main(String[] args) {
    }
}
