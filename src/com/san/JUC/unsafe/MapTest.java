package com.san.JUC.unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/25/17:53
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map1.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(
                        0, 5));
                System.out.println(map1);
            }, String.valueOf(i)).start();
        }
    }
}
