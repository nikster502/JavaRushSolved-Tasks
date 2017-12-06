package com.javarush.task.task20.task2012;

import java.io.*;

/* 
OutputToConsole
Класс OutputToConsole должен сериализовываться с помощью интерфейса Externalizable.
Найди и исправь ошибку.
*/
public class Solution {
    public static String greeting = "Hello world";

    /**
     * OutputToConsole is the inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for the displaying [greeting] variable to the console.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable{
        private int counter;



        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(counter);
        }

        public void readExternal(ObjectInput in) throws IOException {
            counter = in.readInt();
        }

        /**
         * Class constructor specifying fake private field [i].
         */
        public OutputToConsole(int counter) {
            this.counter = counter;
        }

        /**
         * Prints greeting message to console counter times.
         */
        public void printMessage() {
            for (int i = 0; i < counter; i++) {
                System.out.println(greeting);
            }
        }
    }

    public static void main(String[] args) {

    }
}
