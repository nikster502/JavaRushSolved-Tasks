package com.javarush.task.task25.task2506;

/**
 * Created by nik on 15.04.2017.
 */
    public  class LoggingStateThread extends Thread{
        Thread target;

        public LoggingStateThread(Thread target) {
            this.target = target;

        }

        @Override
        public void run() {
            State stateOfTarget = target.getState();
            System.out.println(stateOfTarget);
            while(stateOfTarget!=State.TERMINATED) {
                if (stateOfTarget!= target.getState()) {
                    stateOfTarget = target.getState();
                    System.out.println(stateOfTarget);
                }
            }
        }
    }

