package com.fehead.MoocTest;

import java.lang.reflect.Proxy;

public class SqlSession {
    @SuppressWarnings("unchecked")
    public  <T> T getMapper(Class<T> type){
        System.out.println("通过接口的Class从代理工厂Map取出对应的代理工厂");
        System.out.println("通过代理工厂实例化一个代理类");
        System.out.println("用这个代理类生成一个代理实例返回出去");
        //使用new Class[]{type}：因为第二个参数应该是接口，所以直接使用new Class[]{type}传一个接口就行
        return (T) Proxy.newProxyInstance(type.getClassLoader(),new Class[]{type},new MapperProxy());
    }

}
