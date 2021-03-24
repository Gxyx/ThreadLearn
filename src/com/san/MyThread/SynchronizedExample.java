package com.san.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/04/15:48
 */
public class SynchronizedExample {

    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * 同步一个类
     * 作用于整个类，也就是说两个线程调用同一个类的不同对象上的这种同步语句，也会进行同步。
     */
    public void func2() {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
        /**
         * 它只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。
         *
         * 对于以下代码，使用 ExecutorService 执行了两个线程，由于调用的是同一个对象的同步代码块，
         * 因此这两个线程会进行同步，当一个线程进入同步语句块时，另一个线程就必须等待
         * 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9
         */
        public static void main (String[]args){
//        SynchronizedExample e1 = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e1.func1());

            /**
             * 两个线程调用了不同对象的同步代码块，因此这两个线程就不需要同步。从输出结果可以看出，两个线程交叉执行。
             * 0 1 2 3 4 5 0 1 2 3 4 5 6 7 8 9 6 7 8 9
             */
            SynchronizedExample e1 = new SynchronizedExample();
            SynchronizedExample e2 = new SynchronizedExample();
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(() -> e1.func2());
            executorService.execute(() -> e2.func2());
        }
    }

