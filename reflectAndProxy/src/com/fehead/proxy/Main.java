package com.fehead.proxy;

public class Main {

    public static void main(String[] args){

       Car car = new Car();
//        car.move();
//        Car2 car2 = new Car2();
//        car2.move();
//        CarTimeProxy carTimeProxy = new CarTimeProxy(car);
//        carTimeProxy.move();
        //先日志后时间
//        CarTimeProxy carTimeProxy = new CarTimeProxy(car);
//        CarLogProxy carLogProxy = new CarLogProxy(carTimeProxy);
//        carLogProxy.move();
        //先时间后日志
        CarLogProxy carLogProxy = new CarLogProxy(car);
        CarTimeProxy carTimeProxy = new CarTimeProxy(carLogProxy);
        carTimeProxy.move();
    }
}
