package com.san.JUC;

import java.util.Vector;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/10/17:08
 */
public class SynchronizedTest {
    public synchronized void test1() {
    }

    public void test2() {
        synchronized(this) {
        }
    }

    /**
     * Vector 存在隐性锁
     */
    public void vectoryTest(){
        Vector<String> vector = new Vector<String>();
        for (int i = 0 ; i < 10 ; i++){
            vector.add(i + "");
        }
        System.out.println(vector);
    }

    /**
     * happens-before 原则
     * 线程 A 执行 write(int j)，线程 B 执行 #read()，且线程 A 优先于线程 B 执行
     *
     * 由于两个方法是由不同的线程调用，所以肯定不满足程序次序规则。
     * 两个方法都没有使用锁，所以不满足锁定规则。
     * 变量 i 不是用volatile修饰的，所以 volatile 变量规则不满足。
     * 传递规则肯定不满足。
     * 规则 5、6、7、8 + 推导的 6 条可以忽略，因为他们和这段代码毫无关系。
     *
     */
    private int i = 0;

    public void write(int j){
        i = j;
    }

    public int read(){
        return i;
    }
}
