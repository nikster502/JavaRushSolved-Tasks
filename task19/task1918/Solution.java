package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang=»en» lang=»en»><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, «span«.
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, n, r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми

Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.
*/
import java.io.*;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
       // String fileName = "e:/1.txt";
        String tag = args[0];
        reader.close();
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));
        String s="";
        while (readFile.ready()){
            s+= readFile.readLine();
        }
        readFile.close();
        s = s.replaceAll("\\n|\\r", "");
        String openTag = "(<)(" + tag + ")(([\\s][^>]*)?)(>)";
        String closeTag = "((<)(/)(" + tag + ")(>))";
        Pattern p = Pattern.compile(openTag+"|"+closeTag);
        Matcher m = p.matcher(s);
        Stack<Integer> indexStack = new Stack<>();
        while(m.find()){
            String match = m.group();
            int startIndex = m.start();
            int endIndex = m.end();
            if (Pattern.matches(openTag, match)) {
                indexStack.push(startIndex);
            } else if (Pattern.matches(closeTag, match)) {
                System.out.println(s.substring(indexStack.pop(), endIndex));
            }
        }
    }

}
