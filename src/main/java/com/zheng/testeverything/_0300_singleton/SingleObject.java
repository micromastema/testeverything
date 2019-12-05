package com.zheng.testeverything._0300_singleton;

/**
 * 饿汉
 * @author zhengchentong on 2019/11/21
 */
public class SingleObject {
    private static SingleObject instance = new SingleObject();

    private SingleObject(){}

    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
