package com.fehead.JDKProxy;

import com.fehead.proxy.Car;
import com.fehead.proxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/*
* JDK动态代理测试类
* */
public class Test {

    public static void main(String[] args){
        Car car= new Car();
        InvocationHandler handler = new TimeHandler(car);
        Class cls = car.getClass();

        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),handler);
        m.move();
    }

}
