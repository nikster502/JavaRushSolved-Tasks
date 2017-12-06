package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable,CustomThreadManipulator {
    Thread thread;
    @Override
    public void run() {
        try {
                while(!Thread.interrupted()){
                    thread = Thread.currentThread();
                    System.out.println(thread.getName());
                        Thread.sleep(100);
                    }
        }catch (InterruptedException e) {

                    }

        }
            @Override
    public void start(String threadName) {
        thread = new Thread(this,threadName);
        thread.start();
    }
    @Override
    public void stop() throws InterruptedException {
        thread.interrupt();
    }
}