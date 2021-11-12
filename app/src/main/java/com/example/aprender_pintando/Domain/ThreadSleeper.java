package com.example.aprender_pintando.Domain;

public class ThreadSleeper extends Thread{

    public static void sleep(long seconds){

        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
