package com.zheng.testeverything.model2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhengchentong on 2019-06-15
 */
@Component
public class TestDao2 {
    @Autowired
    private TestMapper2 testMapper2;

    @Transactional(transactionManager = "test2TransactionManager")
    public void insert1() throws Exception {
        int a = 1;
        a = a + 1;
        System.out.println(a);
        String b = a + 1 + "";
        String c = a + 2 + "";
        String d = a + 3 + "";
        String e = a + 4 + "";
        String f = a + 5 + "";
        String g = a + 6 + "";
        testMapper2.insert(String.valueOf(a), b, c, d, e, f, g);
        int i = 1/0;
    }
}
