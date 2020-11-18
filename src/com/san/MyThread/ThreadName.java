package com.san.MyThread;

import java.util.stream.IntStream;

/**
 * @Auther: Gxyx
 * @Date: 2020/11/18/16:19
 */
public class ThreadName {
    public static void main(String[] args) {
        IntStream.range(0,5).boxed().map(i -> new Thread(() -> System.out.println(Thread.currentThread().getName()))).forEach(Thread::start);
    }
}
