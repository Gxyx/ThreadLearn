package com.san.MyThreadApi;

/**
 * @Auther: Gxyx
 * @Date: 2020/11/21/12:23
 */
public class ThreadPriority01 {
    public static void main(String[] args) {
        //定义线程组
        ThreadGroup group = new ThreadGroup("test");
        //将线程组的优先级指定为7
        group.setMaxPriority(7);
        //定义一个线程，将该线程加入到group中
        Thread thread = new Thread(group,"test-thread");
        //企图将线程的优先级设定为10
        thread.setPriority(10);

        System.out.println(thread.getPriority());
    }
}
