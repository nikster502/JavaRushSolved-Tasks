package com.javarush.task.task20.task2025;

import java.util.LinkedList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания
Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8
На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Integer> result_list = new LinkedList<>();
        List<Integer> s_mass;
        int tmp;
        int i;

        for (i = 1; i < N; i++) {
            s_mass = digits(i);
            tmp = 0;
            for (int s_mass_element : s_mass) {
                tmp += pow(s_mass_element, s_mass.size());
            }
            if (tmp == i)
                result_list.add(i);
        }

        if (result_list.size() > 0) {
            result = new long[result_list.size()];
            for (i= 0; i < result_list.size(); i++) {
                result[i] = result_list.get(i);
            }
        }
        return result;
    }

    public static long[] getNumbersSimple(long N) {
        int[] numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153};
        List<Integer> list = new LinkedList<>();
        for (int number : numbers)
        {
            if (number < N)
                list.add(number);
        }
        long[] result = new long[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;

    }

    public static int pow(int base, int exponent)
    {
        if (exponent == 0)
            return 1;

        else if (exponent == 1)
            return base;

        else
        {
            int loop_count = exponent / 2;
            boolean extra = ((exponent % 2) == 1);
            int result = base;

            while (loop_count-- > 0)
                result *= result;

            if (extra)
                result *= base;

            return result;
        }
    }

    public static List<Integer> digits(int i) {
        List<Integer> digits = new LinkedList<>();
        while(i > 0) {
            digits.add(0, i % 10);
            i /= 10;
        }
        return digits;
    }

    public static void main(String[] args) {

    }
}