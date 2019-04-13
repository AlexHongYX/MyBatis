package com.fehead.GuitaiProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args){

        MaoTaiJiu maoTaiJiu = new MaoTaiJiu();

        InvocationHandler jingxiao1 = new GuitaiA(maoTaiJiu);

        SellWine sellWine = (SellWine) Proxy.newProxyInstance(MaoTaiJiu.class.getClassLoader(),MaoTaiJiu.class.getInterfaces(),jingxiao1);
        sellWine.mainJiu();
    }
}
