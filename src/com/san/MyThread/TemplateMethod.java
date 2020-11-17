package com.san.MyThread;



/**
 * 模板方法
 * print 方法类似于 start方法
 * wrapPrint类似于run方法
 *
 * 程序结构由父类控制，并且是由final修饰，不允许被重写，子类只需要实现想要的逻辑任务
 */
public class TemplateMethod {
    public final void print(String message){
        System.out.println("##############");
        wrapPrint(message);
        System.out.println("##############");
    }

    protected void wrapPrint(String message){

    };

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*"+message+"*");
            }
        };
        t1.print("Hello Thread");
        TemplateMethod t2 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+"+message+"+");
            }
        };
        t2.print("Hello Thread");
    }
}

