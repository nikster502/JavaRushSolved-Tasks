package com.javarush.task.task29.task2902;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Рефакторинг в соответствии с Naming and Code Convention 2
Исправить код в соответствии с Naming and Code Convention (Shift+F6 для рефакторинга).


Требования:
1. Переименуй переменную Solution типа Solution в соответствии с Naming and Code Convention.
2. Переименуй переменную file_name_to_be_opened_by_notepad типа String в соответствии с Naming and Code Convention.
3. Переименуй переменную NOTEPAD типа Process в соответствии с Naming and Code Convention.
4. Переименуй метод getprocessstartnotepad в соответствии с Naming and Code Convention.
5. Переименуй параметр FILE_NAME метода принимающего String в соответствии с Naming and Code Convention.
6. Переименуй переменную cmd_array типа String[] в соответствии с Naming and Code Convention.
7. Переименуй метод Getabsolutepathtodefaulttxtfile в соответствии с Naming and Code Convention.
8. Переименуй переменную uRi типа URI в соответствии с Naming and Code Convention.
*/
public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        Solution solution = new Solution();
        String fileNameToBeOpenedByNotepad = solution.getAbsolutePathToDefaultTxtFile().toString();
        Process notepad = solution.getProcessStartNotepad(fileNameToBeOpenedByNotepad);
        notepad.waitFor();
    }

    public Process getProcessStartNotepad(String fileName) throws IOException {
        String[] cmdArray = new String[]{"notepad.exe", fileName};
        return Runtime.getRuntime().exec(cmdArray);
    }

    public Path getAbsolutePathToDefaultTxtFile() {
        URI uri = null;
        try {
            uri = Solution.class.getResource("file.txt").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return  Paths.get(uri);
    }
}
