package com.san.JUC.lock8;

import com.san.MyThreadApi.ThreadJoin;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/24/20:57
 */
public class Test1 {
    // 两个方法用的是同一个锁，谁先拿到谁执行！
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            phone.sendSms();
        },"A").start();

//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new Thread(()->{
            phone.call();
        },"B").start();
    }
}

class Phone{
    //synchronized锁的对象是方法调用者
    //synchronized修饰实例方法时，锁住的是对象实例
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}
