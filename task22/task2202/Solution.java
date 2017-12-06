package com.javarush.task.task22.task2202;

/* 
Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.

Пример:
«JavaRush — лучший сервис обучения Java.»

Результат:
«— лучший сервис обучения»

На некорректные данные бросить исключение TooShortStringException (сделать исключением).
*/
public class Solution  {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if(string==null){
            throw new TooShortStringException();
        }

        int j =0;
        char[]s = string.toCharArray();

    for (int i =0;i<string.length();i++){
        if (String.valueOf(s[i]).equals(" ")){
            ++j;
        }
    }
String[] strings = string.split(" ");
        StringBuilder result;
    if(j<4){
        throw new TooShortStringException();
    }
    else {
        result = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            result.append(strings[i] + " ");
        }
    }
        return result.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
