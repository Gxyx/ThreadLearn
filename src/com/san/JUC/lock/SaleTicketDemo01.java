package com.san.JUC.lock;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/23/23:24
 *
 *
 *
 *
 * 修饰符 interface 接口名称{
 * public abstract 返回值类型 方法名称(可选参数信息);
 * // 其他非抽象方法内容
 * }
 *
 * public interface MyFunctionalInterface {
 *      void myMethod();
 * }
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        // @FunctionalInterface 函数式接口，jdk1.8 lambda表达式 (参数)->{ 代码 }
        new Thread(()->{
            for (int i = 1; i < 40 ; i++) {
                ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 1;i<40;i++){
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i =0;i<40;i++){
                ticket.sale();
            }
        },"C").start();
    }

}

//资源类 OOP
class Ticket{
    //属性    方法
    private int number = 30;

    //synchronized关键字 本质：队列、锁
    public synchronized void sale(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"票,剩余："+number);
        }
    }
}
