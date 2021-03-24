package com.san.JUC;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/05/16:57
 * 死锁
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    private void deadLock(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        Thread.currentThread().sleep(200);
                    } catch (InterruptedException e) {

                    }
                    synchronized (B){
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(B){
                    synchronized(A){
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }
}
