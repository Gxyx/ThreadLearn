package com.san.MyThreadApi.joinDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 查询各大航空公司数据
 * @Auther: Gxyx
 * @Date: 2020/11/21/16:31
 */
public class FightQueryTask extends Thread implements FightQuery {

    private final String origin;

    private final String destination;

    private final List<String> flightList = new ArrayList<>();

    public FightQueryTask(String airline,String origin,String destination){
        super("[" + airline + "]");
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.printf("%s-查询从%s到%s\n",getName(),origin,destination);
        int val = ThreadLocalRandom.current().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(val);
            this.flightList.add(getName() + "---" + val);
            System.out.printf("航班: %s 查询成功\n",getName());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<String> get() {
        return this.flightList;
    }
}

