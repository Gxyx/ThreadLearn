package com.san.MyThreadApi;

/**
 * @Auther: Gxyx
 * @Date: 2020/11/21/12:40
 */
public class CurrentThread {
    public static void main(String[] args) {
        Thread thread =new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread()==this);
            }
        };
        thread.start();

        String name = Thread.currentThread().getName();
        System.out.println("main".equals(name));
    }
}
