package com.san.JUC.function;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/23/23:40
 */
public class Demo2 {
    // 使用自定义的函数式接口作为方法参数
    private static void doSomething(Demo1 demo1){
        // 调用自定义的函数式接口方法
        demo1.myMethod();
    }

    public static void main(String[] args) {
        doSomething(()-> System.out.println("Lambda执行了"));
    }
}
