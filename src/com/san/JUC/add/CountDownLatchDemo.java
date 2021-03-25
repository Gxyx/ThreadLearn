package com.san.JUC.add;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/25/21:46
 */
public class CountDownLatchDemo {
    /**
     * 每次有线程调用 countDown() 数量-1，假设计数器变为0，countDownLatch.await() 就会被唤醒，继续执行！
     * 原理：
     *      countDownLatch.countDown(); // 数量-1
     *      countDownLatch.await(); // 等待计数器归零，然后再向下执行
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        //总数是6，必须要执行任务的时候，在使用
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i =0;i<=6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go out");
                countDownLatch.countDown(); //数量减一
            },String.valueOf(i)).start();
        }
        countDownLatch.await(); //等待计数归零，然后向下执行
        System.out.println("Close Door");
    }
}
