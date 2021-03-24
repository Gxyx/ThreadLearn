package com.san.JUC;

import javax.naming.Context;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/08/15:25
 */
public class VolatileFoo {

    final static int MAX = 5;
    //static  int init_value = 0;
    static volatile int init_value = 0;

    public static void main(String[] args) {
        //启动一个Reader线程，当发现local_value和init_value不同时，则输出init_value被修改的信息
        new Thread(()->{
            int localValue = init_value;
            while(localValue < MAX){
                if (init_value != localValue){
                    System.out.printf("init_value updated to[%d]\n",init_value);
                    //对localValue重新赋值
                    localValue = init_value;
                }
            }
        },"Reader").start();

        //启动Updater线程，主要用于init_value的修改，当local_value>=5的时候则退出生命周期
        new Thread(()->{
            int localValue = init_value;
            while (localValue < MAX){
                System.out.printf("init_value will be change to [%d]\n",++localValue);
                init_value = localValue;
                try {
                    //短暂休眠，目的是为了Reader线程能够来得及输出变化内容
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Updater").start();
    }

    private boolean initialized = false;
    private Context context;

    public Context load(){

        if (!initialized){
           // context = loadContext();
            initialized = true;
        }

        return context;
    }

}
