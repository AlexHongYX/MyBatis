package com.fehead.proxy;

public class Car2 extends Car {

    public void move(){
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");

        super.move();

        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶...汽车行驶时间为："+(endTime-startTime)+"毫秒");
    }
}
