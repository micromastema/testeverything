package com.zheng.testeverything;

import com.zheng.testeverything.service.TestTransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class TesteverythingApplicationTests {

    @Autowired
    TestTransactionService testTransactionService;

    @Test
    public void test(){
        testTransactionService.test();
    }
}
