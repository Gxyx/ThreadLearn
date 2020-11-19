package com.san.MyThreadApi;

import java.util.stream.IntStream;

/**
 * yield方法
 * @Auther: Gxyx
 * @Date: 2020/11/19/15:08
 *  调用yield方法会使当前线程从Running状态切换到Runnable状态
 */
public class ThreadYield {
    public static void main(String[] args) {
        IntStream.range(0,2).mapToObj(ThreadYield::create).forEach(Thread::start);
    }
    private static Thread create(int index){
        return new Thread(()->{
            if (index==0){
                Thread.yield();
            }
            System.out.println(index);
        });
    }
}
