package com.zheng.testeverything.service;

import com.zheng.testeverything.entity.MongoStudyRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author zhengchentong on 2019/12/19
 */
@Service
public class MongodbTestService {

    @Autowired
    @Qualifier(value = "customerMongoTemplate")
    private MongoTemplate customerMongoTemplete;

    public void test() {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("openid").is("");
        criteria.and("channel_id").is("");
        query.addCriteria(criteria);
        MongoStudyRecordEntity one = customerMongoTemplete.findOne(query, MongoStudyRecordEntity.class, "member");
        String id = Objects.requireNonNull(one).getId();
    }
}
