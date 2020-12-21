package com.san.MyThreadApi;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: Gxyx
 * @Date: 2020/11/21/17:58
 */
public class InterruptThreadExit {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
//                System.out.println("I will start work");
//                while (!isInterrupted()){
//
//                }
//                System.out.println("I will be exiting");
                System.out.println("I will start work");
                for (;;){
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                System.out.println("I will be exiting");
            }
            };
        t.start();
        TimeUnit.MINUTES.sleep(1);
        System.out.println("System will be shutdowm");
        t.interrupt();
    }
}
