package com.san.JUC.singleton;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/23/8:16
 * 一个类只能构建一个对象
 */

public class Singleton {
    //私有构造函数
    private Singleton(){};
    //单例对象
    private volatile static Singleton instance = null;
    //静态工厂方法
    public static Singleton getInstance(){
        //双重检测机制
        if (instance==null) {
            //同步锁
            synchronized (Singleton.class) {
                //双重检测机制
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
