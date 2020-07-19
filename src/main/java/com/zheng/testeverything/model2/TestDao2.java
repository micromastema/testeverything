package com.zheng.testeverything.model2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhengchentong on 2019-06-15
 */
@Component
public class TestDao2 {
    @Autowired
    private TestMapper2 testMapper2;

    public void insert1() throws Exception {
        testMapper2.insert(3, "3");
        testMapper2.insert(4, "4");
        int a = 0;
    }
}
