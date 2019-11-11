package com.zheng.testeverything.service;

/**
 * @author zhengchentong on 2019/10/18
 */
public class testthread extends Thread {
    bianliang bianliang;
    public testthread(bianliang bianliang) {
        this.bianliang = bianliang;
    }
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            bianliang.add();
        }
    }
}
