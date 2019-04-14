package com.fehead.MyProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

    private Object pinpai;

    public MyHandler(Object pinpai){
        super();
        this.pinpai = pinpai;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Show Time");

        method.invoke(pinpai);

        System.out.println("End Time");
        return null;
    }
}
