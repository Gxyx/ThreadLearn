package com.san.JUC;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/11/9:41
 */
public class RecordExample2 {

    private static int a = 0;
    boolean flag = false;

    /**
     * 线程A执行
     */
    public  void write(){
        a = 1;
        flag = true;
    }

    /**
     * B线程执行
     */
    public void read(){
        if (flag) {
            int i = a + a;
        }
    }

    public static void main(String[] args) {
        RecordExample2 recordExample1 = new RecordExample2();
        RecordExample2 recordExample2 = new RecordExample2();
        recordExample1.write();
        recordExample2.read();
        System.out.println(a);
    }
}
