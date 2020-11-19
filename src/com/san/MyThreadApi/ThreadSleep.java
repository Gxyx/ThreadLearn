package com.san.MyThreadApi;

/**
 * sleep方法
 * @Auther: Gxyx
 * @Date: 2020/11/19/14:36
 */
public class ThreadSleep {
    public static void main(String[] args) {

        //自定义线程
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            sleep(2_00L);
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("Total spend %d ms",(endTime-startTime)));
        }).start();
        //主线程
        long startTime = System.currentTimeMillis();
        sleep(3_00L);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Main thread total %d ms",(endTime-startTime)));
    }
    private static void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
