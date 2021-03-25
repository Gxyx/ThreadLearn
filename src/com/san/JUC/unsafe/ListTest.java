package com.san.JUC.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/25/15:38
 */
public class ListTest {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<>();
        //List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        /**
         * CopyOnWrite 写入时复制 COW 计算机程序设计领域的一种优化策略；
         * 多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）
         * 在写入的时候避免覆盖，造成数据问题！
         * 读写分离
         */
        List<String> list = new CopyOnWriteArrayList<>();
        //List<String> list1 = new CopyOnWriteArrayList<>();
//        for (int i=0;i<=10;i++){
//            list.add(UUID.randomUUID().toString().substring(0,5));
//            System.out.println(list);
//        }
        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }



    }
}
