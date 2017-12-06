package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
d:/java/copy.txt
d:/java/copy1.txt
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

while (file.ready()){
    String s = file.readLine();
    Charset koi = Charset.forName("Windows-1251");
    Charset koi8 = Charset.forName("UTF-8");
    byte[] buffer = s.getBytes(koi);
    String s1 = new String(buffer,koi8);
   writer.write(s1);
}

        file.close();
        writer.close();
    }
}
