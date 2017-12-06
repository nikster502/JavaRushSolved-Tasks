package com.javarush.task.task20.task2003;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
Про .properties почитать тут — http://ru.wikipedia.org/wiki/.properties
Реализуй логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
public static  Properties pro = new Properties();
    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String  s  =reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(s);
        load(fileInputStream);
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter writer = new PrintWriter(outputStream);
        for (Map.Entry<String, String> stringStringEntry : properties.entrySet()) {
            StringBuilder key = new StringBuilder(stringStringEntry.getKey());
            StringBuilder value = new StringBuilder(stringStringEntry.getValue());
            //adding escape characters if needed
            for (int i = 0; i < key.length(); i++) {
                if ("#! =:".indexOf(key.charAt(i)) != -1)
                    if (i == 0 || key.charAt(i-1) != '\\')
                        key.insert(i, '\\');
            }
            //adding escape characters if needed (don't process SPACE characters)
            for (int i = 0; i < value.length(); i++) {
                if ("#!=:".indexOf(value.charAt(i)) != -1)
                    if (i == 0 || value.charAt(i-1) != '\\')
                        value.insert(i, '\\');
            }
            writer.println(key + "=" + value);
        }
        writer.close();

    }

    public void load(InputStream inputStream) throws Exception {

        pro.load(inputStream);
        for (Map.Entry<Object, Object> kv : pro.entrySet())
            properties.put(kv.getKey().toString(), kv.getValue().toString());

    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();


        FileOutputStream outputStream = new FileOutputStream("d:/copy1.txt");
        solution.save(outputStream);
        outputStream.close();
    }
}
