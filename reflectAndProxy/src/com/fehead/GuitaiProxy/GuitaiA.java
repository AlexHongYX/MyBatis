package com.fehead.GuitaiProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GuitaiA implements InvocationHandler {

    private Object pinpai;

    public GuitaiA(Object pinpai){
        super();
        this.pinpai = pinpai;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("销售开始 柜台是："+this.getClass().getSimpleName());
        method.invoke(pinpai);
        System.out.println("销售结束");
        return null;
    }
}
