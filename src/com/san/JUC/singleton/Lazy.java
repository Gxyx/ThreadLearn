package com.san.JUC.singleton;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/23/8:34
 */
public class Lazy {
    private static class LazyHolder{
        private static final Lazy INSTANCE = new Lazy();
    }
    private Lazy(){

    }
    public static Lazy getInstance(){
        return LazyHolder.INSTANCE;
    }
}
