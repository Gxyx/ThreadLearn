package com.san.MyThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/04/21:06
 * 线程不安全示例
 */
public class ThreadUnsafeExample {
    /**
     * 如果多个线程对同一个共享数据进行访问而不采取同步操作的话，那么操作的结果是不一致的。
     *
     *  1000 个线程同时对 cnt 执行自增操作，操作结束之后它的值有可能小于 1000。
     */
    private int cnt = 0;
    public void add(){
        cnt++;
    }
    public int get(){
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }
}
