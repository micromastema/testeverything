//package com.zheng.testeverything.model1;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * @author zhengchentong on 2019-06-15
// */
//@Component
//public class TestDao1 {
//
//    @Autowired
//    private TestMapper1 testMapper1;
//
//    @Transactional(transactionManager = "test1TransactionManager")
//    public void insert1() throws Exception {
//        int a = 1;
//        a = a + 1;
//        System.out.println(a);
//        String b = a + "";
//        String c = a + "";
//        String d = a + "";
//        String e = a + "";
//        String f = a + "";
//        String g = a + "";
//        testMapper1.insert(String.valueOf(a), b, c, d, e, f, g);
//        int i = 1/0;
//    }
//}
