package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Запрет сериализации
Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution  {
        private void writeObject(ObjectOutputStream out) throws IOException, InterruptedException
        {
            throw new NotSerializableException();
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
