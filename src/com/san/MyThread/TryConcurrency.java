package com.san.MyThread;


import java.util.concurrent.TimeUnit;


public class TryConcurrency {
    public static void main(String[] args) {
//        browseNews();
//        enjoyMusic();
        new Thread() {
            @Override
            public void run() {
                super.run();
                enjoyMusic();
            }
        }.start();
        browseNews();

    }

    /**
     * 浏览新闻
     */
    private static void browseNews()   {
        for (;;){
            System.out.println("is good news");
            sleep(1);
        }
    }

    /**
     * 听音乐
     */
    private static void enjoyMusic()  {
        for (;;){
            System.out.println("is good musics");
            sleep(1);
        }
    }

    /**
     *
     * @param seconds
     */
    private static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
