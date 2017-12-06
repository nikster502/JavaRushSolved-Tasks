package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый — path — путь к директории, второй — resultFileAbsolutePath — имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его (используй метод FileUtils.deleteFile).
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
2.2.2. Переименовать resultFileAbsolutePath в ‘allFilesContent.txt‘ (используй метод FileUtils.renameFile).
2.2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять «n«.
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        File file = new File("d:/films/resultFileAbsolutePath.txt");
        FileUtils.renameFile(file,new File(file.getParent()+"/allFilesContent.txt"));

        FileOutputStream out=new FileOutputStream(file.getParent()+"/allFilesContent.txt");
        ArrayList<File> list = new ArrayList<>();
        for (File f : file.listFiles()){
            if (f.length()>50){
                FileUtils.deleteFile(f);
            }
            else
                list.add(f);
        }
        Collections.sort(list);
        PrintWriter writer = new PrintWriter(out);

        for (File l : list) {
            writer.println(String.valueOf(l));
        }
        writer.close();
        out.close();
    }
    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
