package com.san.MyThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: Gxyx
 * @Date: 2020/11/19/13:44
 */
public class ThreadCounter extends Thread {
    final static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        try {
            while (true) {
                new ThreadCounter().start();
            }
        } catch (Throwable e) {
            System.out.println("failed At=>" + counter.get());
        }
    }
    public void run(){
        try {
            System.out.println("The"+counter.getAndIncrement()+"thread be created");
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
