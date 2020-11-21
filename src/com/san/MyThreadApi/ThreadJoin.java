package com.san.MyThreadApi;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @Auther: Gxyx
 * @Date: 2020/11/21/15:36
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        //1、定义两个线程，保存在join方法中
        List<Thread> threads = IntStream.range(1,3).mapToObj(ThreadJoin::create).collect(toList());
        //2.启动这个线程
        threads.forEach(Thread::start);
        //3.执行这两个线程的join方法
        for (Thread thread:threads){
            thread.join();
        }
       //4、mian线程循环输出
        for (int i =0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"#"+i);
            shortSleep();
        }
    }

    //一个简单线程，每个线程只是简单的输出
    private static Thread create(int seq){
        return new Thread(()->{
            for (int i =0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"#"+i);
                shortSleep();
            }
        },String.valueOf(seq));
    }

    private static  void shortSleep(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
