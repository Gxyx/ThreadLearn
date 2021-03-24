package com.san.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/04/20:52
 * Semaphore
 */
public class SemaphoreExample {
    /**
     * Semaphore 类似于操作系统中的信号量，可以控制对互斥资源的访问线程数。
     * @param args
     * 模拟了对某个服务的并发请求，每次只能有 3 个客户端同时访问，请求总数为 10
     */
    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i =0;i < totalRequestCount;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.print(semaphore.availablePermits()+" ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }

}
