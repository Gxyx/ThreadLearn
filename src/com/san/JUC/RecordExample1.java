package com.san.JUC;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/11/9:36
 */
public class RecordExample1 {

    /**
     * JVM 对异常做了一种特殊的处理，为了保证 as-if-serial 语义，Java 异常处理机制对重排序做了一种特殊的处理：
     * JIT 在重排序时，会在catch 语句中插入错误代偿代码（a = 3），这样做虽然会导致 catch 里面的逻辑变得复杂，
     * 但是 JIT 优化原则是：尽可能地优化程序正常运行下的逻辑，哪怕以 catch 块逻辑变得复杂为代价。
     *
     * 单线程
     * @param args
     */
    public static void main(String[] args) {
        int a =1;
        int b= 2;

        try {
            a = 3;
            b = 1 / 0;
        }catch (Exception e){

        }finally {
            System.out.println("a= "+a);
        }
    }
}
