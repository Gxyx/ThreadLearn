package com.san.MyThread;

import java.util.stream.IntStream;

/**
 * @Auther: Gxyx
 * @Date: 2020/11/18/16:43
 */
public class MyThreadName {
    private final static String PREFIX = "san-";
    public static void main(String[] args) {
        IntStream.range(0,5).mapToObj(MyThreadName::createdThread).forEach(Thread::start);
    }

    private static Thread createdThread(final int intName){
        return new Thread(()-> System.out.println(Thread.currentThread().getName()),PREFIX+intName);
    }
}
