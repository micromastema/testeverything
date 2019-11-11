package com.zheng.testeverything.service;

/**
 * @author zhengchentong on 2019/10/18
 */
public class testmain {

    public static void main(String[] args) {
        bianliang b = new bianliang();
        testthread t1 = new testthread(b);
        testthread t2 = new testthread(b);
        t1.start();
        t2.start();
    }
}
