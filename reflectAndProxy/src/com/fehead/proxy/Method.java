package com.fehead.proxy;

import java.util.ArrayList;

public class Method {

    public static void main(String[] args){
        ArrayList arrayList1 = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<String>();

        arrayList1.add("hello");
        arrayList2.add("hello");
        //编译会报错
        //arrayList2.add(15);
        Class class1 = arrayList1.getClass();
        Class class2 = arrayList2.getClass();
        System.out.println(class1==class2);

        try {
            java.lang.reflect.Method method = class2.getMethod("add",Object.class);
            method.invoke(arrayList2,20);
            System.out.println(arrayList2.size());
            System.out.println(arrayList2);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
