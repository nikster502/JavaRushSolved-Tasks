package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент — имя результирующего файла resultFileName, остальные аргументы — имена файлов fileNamePart.
Каждый файл (fileNamePart) — это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002


Требования:
1. В методе main нужно создать ZipInputStream для архива, собранного из кусочков файлов. Файлы приходят аргументами в main, начиная со второго.
2. Создай поток для записи в файл, который приходит первым аргументом в main. Запиши туда содержимое файла из архива.
3. Поток для чтения из архива должен быть закрыт.
4. Поток для записи в файл должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];
        int countArgs = args.length-1;
        String[] fileNamePart = new String[countArgs];
        for (int i=0;i<countArgs;i++){
            fileNamePart[i]= args[i+1];
        }
        Arrays.sort(fileNamePart);
        List<FileInputStream> fisList = new ArrayList<>();

        for (int i = 0; i < countArgs; i++) {
            fisList.add(new FileInputStream(fileNamePart[i]));
        }
        SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList));
        ZipInputStream zipInputStream = new ZipInputStream(seqInStream);
        FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);
        byte[] bytes = new byte[1024*1024];
        while ( zipInputStream.getNextEntry()!=null){
int count;
            while ((count = zipInputStream.read(bytes)) != -1)
               fileOutputStream.write(bytes, 0, count);
        }
        zipInputStream.close();
        seqInStream.close();
        fileOutputStream.close();
    }

}
