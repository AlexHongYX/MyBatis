package com.fehead.proxy;

public class Test {

    public static void main(String[] args){
        try {
            Class c = Class.forName(args[0]);
            Office office = (Office)c.newInstance();
            office.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
