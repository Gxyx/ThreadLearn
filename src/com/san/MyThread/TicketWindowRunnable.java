package com.san.MyThread;

/**
 * @Auther: Gxyx
 * @Date: 2020/11/18/14:11
 */
public class TicketWindowRunnable implements Runnable {

    //最多受理50笔业务
    private static final int MAX = 50;

    private  int index = 1;


    @Override
    public void run() {
        while (index<=MAX){
            System.out.println(Thread.currentThread()+"的号码是:"+(index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        final TicketWindowRunnable task = new TicketWindowRunnable();
        Thread windowThread1 = new Thread(task,"一号窗口");
        Thread windowThread2 = new Thread(task,"二号窗口");
        Thread windowThread3 = new Thread(task,"三号窗口");
        Thread windowThread4 = new Thread(task,"四号窗口");
        windowThread1.start();;
        windowThread2.start();
        windowThread3.start();
        windowThread4.start();
    }
}
