package com.fehead.MyProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args){

        HaoMao haoMao = new HaoMao();
        InvocationHandler handler = new MyHandler(haoMao);

        Cigarette cigarette1 = (Cigarette) Proxy.newProxyInstance(HaoMao.class.getClassLoader(),HaoMao.class.getInterfaces(),handler);
        cigarette1.SellCigarette();
    }
}
