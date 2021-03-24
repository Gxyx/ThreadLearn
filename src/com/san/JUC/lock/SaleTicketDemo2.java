package com.san.JUC.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/24/19:29
 */
public class SaleTicketDemo2 {
    public static void main(String[] args) {
        Ticket2 ticket2 = new Ticket2();
        // @FunctionalInterface 函数式接口，jdk1.8 lambda表达式 (参数)->{ 代码 }
        new Thread(()->{
            for (int i =1;i<=40;i++){
             ticket2.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i =1;i<=40;i++){
                ticket2.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i =1;i<=40;i++){
                ticket2.sale();
            }
        },"C").start();
    }

}

class Ticket2{
    private int number = 30;
    //可重入锁  一个可重入互斥Lock具有与使用synchronized方法和语句访问的隐式监视锁相同的基本行为和语义，但具有扩展功能。
    Lock lock = new ReentrantLock();

    public void sale(){
        //加速
        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"票,剩余："+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }
    }

}
