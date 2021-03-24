package com.san.MyThreadApi;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: Gxyx
 * @Date: 2020/11/21/14:27
 */
public class  Threadinterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.interrupted());
                }
            }
        };
        thread.setDaemon(true);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }
}
