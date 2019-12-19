package com.zheng.testeverything.service;

import com.zheng.testeverything.entity.MongoStudyRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
    private MongoTemplate mongoTemplate;

    public void test() {
        Query query = new Query(Criteria.where("_id").is("oCay4s1uDNdVk8MmMM6fczin9PM8"));
        MongoStudyRecordEntity one = mongoTemplate.findOne(query, MongoStudyRecordEntity.class, "studyRecord");
        String id = Objects.requireNonNull(one).getId();
    }
}
