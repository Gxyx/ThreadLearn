package com.san.MyThreadApi;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: Gxyx
 * @Date: 2020/11/21/14:39
 */
public class Threadinterrupted01 {
    public static void main(String[] args) {

        // 1、
        System.out.println("Main thread is interrupted?"+Thread.currentThread().isInterrupted());
        //System.out.println("Main thread is interrupted?"+Thread.interrupted());

        //中断当前线程
        Thread.currentThread().interrupt();

        //2、
      //  System.out.println("Main thread is interrupted?"+Thread.currentThread().isInterrupted());
        System.out.println("Main thread is interrupted?"+Thread.interrupted());
        try {
            TimeUnit.MINUTES.sleep(1);
            System.out.println("I am come ");
        } catch (InterruptedException e) {
            System.out.println("I will be interupted still");
        }
    }
}
