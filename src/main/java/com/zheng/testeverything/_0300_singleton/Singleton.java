package com.zheng.testeverything._0300_singleton;

/**
 * @author zhengchentong on 2019/11/21
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    void showMessage() {
        System.out.println("Hello World!");
    }
}
