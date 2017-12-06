package com.javarush.task.task19.task1921;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static java.lang.String.valueOf;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] — может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] — int, [месяц] — int, [год] — int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String s;
        while ((s = reader.readLine())!=null){
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            PEOPLE.add(new Person(isName(s),isDate(s)));
        }
        reader.close();
    }
    public  static Date isDate(String s) throws ParseException {
        char[] strings = s.toCharArray();
for (int i=0;i<s.length();i++){
    if (isNumber(valueOf(strings[i]))){
        String  c="";
        for (int j=i;j<strings.length;j++) {
            c += strings[j];
        }
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        Date date = format.parse(c);
        return date;
    }

}
        return null;
    }
    public  static String isName(String s) throws ParseException {
        char[] strings = s.toCharArray();
        for (int i=0;i<s.length();i++){
            if (isNumber(valueOf(strings[i]))){
                String  c="";
                for (int j=0;j<i-1;j++) {
                    c += strings[j];
                }

                return c;
            }
        }
        return null;
    }
    public static boolean isNumber(String s) {
        try{
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }
}
