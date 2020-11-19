package com.san.MyThread;

/**
 * @Auther: Gxyx
 * @Date: 2020/11/19/13:57
 */
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        //main线程开始
        Thread thread = new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //thread.setDaemon(true);  //将thread设置为守护线程
        thread.start();   //启动thread线程
        Thread.sleep(2_00L);
        System.out.println(thread.isDaemon());
        System.out.println("Main thread finished lifecycle.");
        //main线程结束
    }

}
