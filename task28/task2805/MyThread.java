package com.javarush.task.task28.task2805;

/**
 * Created by nik on 01.09.2017.
 */
public class MyThread extends Thread {
    private static int priority=0;
    private int id = ++priority;

    public  void setPriority() {
        int priority = id % 10;
        if (priority==0){
            priority=10;
        }

        int maxPriority = Thread.currentThread().getThreadGroup().getMaxPriority();
        if (priority>maxPriority){
            priority = maxPriority;
        }
        this.setPriority(priority);
    }

    public MyThread() {
this.setPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority();
    }

    public MyThread(String name) {
        super(name);
        this.setPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority();
    }
}
