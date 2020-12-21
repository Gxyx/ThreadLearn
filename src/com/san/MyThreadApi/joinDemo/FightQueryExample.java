package com.san.MyThreadApi.joinDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现类
 * @Auther: Gxyx
 * @Date: 2020/11/21/16:42
 */
public class FightQueryExample {
    private static List<String> fightCompany = Arrays.asList("CSA","CEA","HNA");

    public static void main(String[] args) {
        List<String> result = search("SH","BJ");
        System.out.println("=========result========");
        result.forEach(System.out::println);
    }

    private static List<String> search(String original,String dest){
        final List<String> result = new ArrayList<>();

        //创建查询航班信息的线程列表
        List<FightQueryTask> tasks = fightCompany.stream().map(f->createSearchTask(f,original,dest)).collect(Collectors.toList());
        //启动线程
        tasks.forEach(Thread::start);
        //分别调用每一个线程加入join方法，阻塞当前线程
        tasks.forEach(t->
                {
                    try {
                        t.join();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
        );
        //当前线程会被阻塞注，获取每一个查询线程的结果，并加入到result中
        tasks.stream().map(FightQueryTask::get).forEach(result::addAll);
        return result;
    }


    private static FightQueryTask createSearchTask(String fight,String original,String dest){
        return new FightQueryTask(fight,original,dest);
    }

}