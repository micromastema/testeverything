package com.zheng.testeverything.elasticsearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zhengct
 * @date 2020/4/11
 */
@RunWith(SpringRunner.class)
//启动Spring
@SpringBootTest
public class ElasticSearchServiceTest {

    @Autowired
    private ElasticSearchService elasticSearchService;

    @Test
    public void test() {
        List<Entity> doc = elasticSearchService.getDoc();
        for (Entity entity : doc) {
            System.out.println(entity.toString());
        }
    }

}
