package com.fehead.proxy;

import java.util.Random;

public class Car implements Moveable {

    @Override
    public void move() {
//        long startTime = System.currentTimeMillis();
//        System.out.println("汽车开始行驶...");

        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车正在行驶...");
        }catch (Exception e){
            e.printStackTrace();
        }


//
//        long endTime = System.currentTimeMillis();
//        System.out.println("汽车结束行驶...汽车行驶时间为："+(endTime-startTime)+"毫秒");
    }
}
