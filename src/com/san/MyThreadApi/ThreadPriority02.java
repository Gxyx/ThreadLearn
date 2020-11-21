package com.san.MyThreadApi;

/**
 * @Auther: Gxyx
 * @Date: 2020/11/21/12:32
 */
public class ThreadPriority02 {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        System.out.println("t1 priority"+t1.getPriority());
        Thread t2 = new Thread(()->{
            Thread t3 = new Thread();
            System.out.println("t3 priority"+t3.getPriority());
        });
        t2.setPriority(6);
        t2.start();
        System.out.println("t2 priority"+t2.getPriority());
    }
}
