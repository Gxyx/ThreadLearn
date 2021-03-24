package com.san.MyThread;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/04/15:20
 */
public class InterruptExample {
    /**
     * 通过调用一个线程的 interrupt() 来中断该线程，
     * 如果该线程处于阻塞、限期等待或者无限期等待状态，那么就会抛出 InterruptedException，
     * 从而提前结束该线程。但是不能中断 I/O 阻塞和 synchronized 锁阻塞。
     */
    private static class MyThread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        Thread thread = new MyThread();
//        thread.start();
//        thread.interrupt();
//        System.out.println("Main run");
//    }
public static void main(String[] args) throws InterruptedException {
    Thread thread2 = new MyThread2();
    thread2.start();
    thread2.interrupt();
}

    /**
     * 如果一个线程的 run() 方法执行一个无限循环，并且没有执行 sleep() 等会抛出 InterruptedException 的操作，
     * 那么调用线程的 interrupt() 方法就无法使线程提前结束。
     *
     * 但是调用 interrupt() 方法会设置线程的中断标记，此时调用 interrupted() 方法会返回 true。
     * 因此可以在循环体中使用 interrupted() 方法来判断线程是否处于中断状态，从而提前结束线程。
     */
    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
                // ..
            }
            System.out.println("Thread end");
        }
    }
}
