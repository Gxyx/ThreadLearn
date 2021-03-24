package com.san.MyThread;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/04/10:25
 * 实现 Runnable 接口
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("线程执行了");
    }

    /**
     * 实现 Runnable 和 Callable 接口的类只能当做一个可以在线程中运行的任务，不是真正意义上的线程，
     * 因此最后还需要通过 Thread 来调用。可以理解为任务是通过线程驱动从而执行的。
     * @param args
     */
    public static void main(String[] args) {
        MyRunnable thread01 = new MyRunnable();
        Thread thread = new Thread(thread01);
        thread.start();
    }


}
