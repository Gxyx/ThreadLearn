package com.san.MyThread;

/**
 * Thread Group
 * @Auther: Gxyx
 * @Date: 2020/11/18/18:29
 */
public class ThreadConstruction  {
    public static void main(String[] args) {

//        Thread t1 = new Thread("t1");
//        ThreadGroup group = new ThreadGroup("TestGroup");
//        Thread t2 = new Thread(group,"t2");
//        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
//        System.out.println("Main thread belong group:"+mainThreadGroup.getName());
//        System.out.println("t1 and main belong the same group:"+(mainThreadGroup==t1.getThreadGroup()));
//        System.out.println("t2 thraed not belong main group:"+(mainThreadGroup==t2.getThreadGroup()));
//        System.out.println("t2 thrad group belong main TestGroup:"+(group==t2.getThreadGroup()));
        if (args.length<1){
            System.out.println("Please enter the stack size.");
            System.exit(1);
        }
        ThreadGroup group = new ThreadGroup("TestGroup");
        Runnable runnable =new Runnable(){
            final int MAX = Integer.MAX_VALUE;

            @Override
            public void run() {
                int i = 0;
                recurse(i);
            }
            private void recurse(int i ){
                System.out.println(i);
                if (i<MAX){
                    recurse(i+1);
                }
            }
        };
        Thread thread = new Thread(group,runnable,"Test",Integer.parseInt(args[0]));
        thread.start();
    }

    /**
     * Main thread belong group:main
     * t1 and main belong the same group:true
     * t2 thraed not belong main group:false
     * t2 thrad group belong main TestGroup:true
     */
}
