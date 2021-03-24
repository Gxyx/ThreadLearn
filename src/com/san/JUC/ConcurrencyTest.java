package com.san.JUC;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/05/9:42
 */
public class ConcurrencyTest {
    /**
     * 1万
     * concurrency : 1ms,b=-10001
     * serial:0ms,b=-10001,a=50005
     *
     * 10万
     * concurrency : 3ms,b=-100001
     * serial:4ms,b=-100001,a=500005
     *
     * concurrency : 2ms,b=-100001
     * serial:2ms,b=-100001,a=500005
     */
    private static final long count = 100001;

    private static void concurrency() throws InterruptedException {
        long start  = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0;i<count;i++){
                    a = a+5;
                }
            }
        });
        thread.start();
        int b = 0 ;
        for (long i = 0;i<count;i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency : "+time+"ms,b="+b);
    }

    private static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0;i<count;i++){
            a+=5;
        }
        int b = 0;
        for (long i = 0;i<count;i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time+"ms,b="+b+",a="+a);
    }

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }
}
