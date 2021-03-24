package com.san.JUC;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/11/10:19
 */
public class VolatileTest {
    int i = 0;
    volatile boolean flag = false;

    //线程A
    public void write(){
        i = 2;
        flag = true;
    }

    //线程B
    public void read(){
        if (flag){
            System.out.println("----i = " + i);
        }
    }
}
