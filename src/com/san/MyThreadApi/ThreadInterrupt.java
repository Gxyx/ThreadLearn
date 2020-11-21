package com.san.MyThreadApi;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: Gxyx
 * @Date: 2020/11/21/13:11
 */
public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Oh,i am be interrupted");
            }
        });
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }
}
