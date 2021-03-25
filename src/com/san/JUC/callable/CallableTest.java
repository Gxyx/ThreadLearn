package com.san.JUC.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/25/21:38
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //new Thread(new Runnable()).start();
        //new Thread(new FutureTask<V>()).start();
        //new Thread(new FutureTask<V>( Callable )).start();
        new Thread().start();
        MyThread thread = new MyThread();
        //适配类
        FutureTask futureTask = new FutureTask(thread);
        new Thread(futureTask,"A").start();
        //结果会被缓存，效率高
        new Thread(futureTask,"B").start();
        //这个get 方法可能会产生阻塞！把他放到最后
        //或者使用异步通信来处理！
        Integer o = (Integer) futureTask.get();
        System.out.println(o);
    }
}

class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        //耗时操作
        return 1024;
    }
}
