package com.san.MyThread;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/04/10:34
 */
public class MyThread  extends Thread{
    public void run() {
        System.out.println("线程运行了");
    }

    /**
     * 同样也是需要实现 run() 方法，因为 Thread 类也实现了 Runable 接口。
     * 当调用 start() 方法启动一个线程时，虚拟机会将该线程放入就绪队列中等待被调度，当一个线程被调度时会执行该线程的 run() 方法。
     * @param args
     */
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
