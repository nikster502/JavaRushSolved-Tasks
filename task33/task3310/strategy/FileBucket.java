package com.javarush.task.task33.task3310.strategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by nik on 05.12.2017.
 */
public class FileBucket {
    private Path path;

    public FileBucket() throws IOException {
        this.path  = File.createTempFile("temp-file-name",
                ".tmp").toPath();
    }
}
