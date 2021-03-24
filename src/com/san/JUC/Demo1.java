package com.san.JUC;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/23/22:40
 */
public class Demo1 {
    public static void main(String[] args)  {
        //查看CPU核数   CPU 密集型，IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
