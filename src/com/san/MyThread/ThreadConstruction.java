package com.san.MyThread;

/**
 * Thread Group
 * @Auther: Gxyx
 * @Date: 2020/11/18/18:29
 */
public class ThreadConstruction  {
    public static void main(String[] args) {

        Thread t1 = new Thread("t1");
        ThreadGroup group = new ThreadGroup("TestGroup");
        Thread t2 = new Thread(group,"t2");
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("Main thread belong group:"+mainThreadGroup.getName());
        System.out.println("t1 and main belong the same group:"+(mainThreadGroup==t1.getThreadGroup()));
        System.out.println("t2 thraed not belong main group:"+(mainThreadGroup==t2.getThreadGroup()));
        System.out.println("t2 thrad group belong main TestGroup:"+(group==t2.getThreadGroup()));
    }

}
