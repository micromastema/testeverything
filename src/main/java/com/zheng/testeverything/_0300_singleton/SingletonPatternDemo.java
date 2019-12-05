package com.zheng.testeverything._0300_singleton;

/**
 * @author zhengchentong on 2019/11/21
 */
public class SingletonPatternDemo {

    public static void main(String[] args) {
        SingleObject instance = SingleObject.getInstance();
        instance.showMessage();

        Singleton instance1 = Singleton.getInstance();
        instance1.showMessage();

    }
}
