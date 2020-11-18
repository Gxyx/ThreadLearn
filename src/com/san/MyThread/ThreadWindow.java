package com.san.MyThread;

/**
 * 模拟营业叫号
 * @Auther: Gxyx
 * @Date: 2020/11/17/19:29
 */
public class ThreadWindow extends Thread {

    //柜台名称
    private final String name;

    //最多受理50笔业务
    private static final int MAX = 50;

    private static int index = 1;

    public ThreadWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index<=MAX){
            System.out.println("柜台："+name+"当前的号码是:"+(index++));
        }
    }


    public static void main(String[] args) {
        ThreadWindow  threadWindow1 = new ThreadWindow("一号出号机");
        threadWindow1.start();
        ThreadWindow  threadWindow2 = new ThreadWindow("二号出号机");
        threadWindow2.start();
        ThreadWindow  threadWindow3 = new ThreadWindow("三号出号机");
        threadWindow3.start();
        ThreadWindow  threadWindow4 = new ThreadWindow("四号出号机");
        threadWindow4.start();
    }
}
