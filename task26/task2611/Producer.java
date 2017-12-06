package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nik on 15.07.2017.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        int count =1;
        while (true) {
            try {
                Thread.sleep(500);
                map.put(String.valueOf(count),"Some text for "+count);
                count++;
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+" thread was terminated");
            }
        }
    }
}
