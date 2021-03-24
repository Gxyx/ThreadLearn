package com.san.JUC.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/24/21:10
 */
public class Test2 {
    public static void main(String[] args) {
        //两个对象两把锁，两个调用者，
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();
        //锁的存在
        new Thread(()->{
            phone1.sendSms();
        },"A").start();
        // 捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        new Thread(()->{
//            phone1.hello();
//        },"B").start();
        new Thread(()->{
            phone2.call();
        },"B").start();
    }
}

class Phone2{
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

    //没有锁不受影响
    public void hello(){
        System.out.println("hello");
    }
}
