package com.san.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/04/11:07
 */
public class MyExecutor {

    /**
     * 调用 Executor 的 shutdown() 方法会等待线程都执行完毕之后再关闭，
     * 但是如果调用的是 shutdownNow() 方法，则相当于调用每个线程的 interrupt() 方法。
     * @param args
     */
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            executorService.execute(new MyRunnable());
//        }
//        executorService.shutdown();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //executorService.shutdown();
        executorService.shutdownNow();
        System.out.println("Main run");
    }
}
