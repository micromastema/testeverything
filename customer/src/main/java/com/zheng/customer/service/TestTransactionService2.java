package com.zheng.customer.service;

import com.zheng.customer.model1.TestMapper3;
import com.zheng.customer.model2.TestMapper4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengchentong on 2019-06-15
 */
@Service
public class TestTransactionService2 {

    public String testservice(){
        return "a";
    }


    @Autowired
    TestMapper3 testMapper3;
    @Autowired
    TestMapper4 testMapper4;
    public String testservice2(){
        String getid = testMapper3.getid("1");

        String getid1 = testMapper4.getid("2");
        return getid+","+getid1;
    }
}
