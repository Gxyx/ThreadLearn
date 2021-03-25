package com.san.JUC.add;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/25/21:59
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙成功");
        });
        for (int i =1;i<=7;i++){
            final int tmp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集"+tmp+"个");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            }).start();
        }
    }
}
