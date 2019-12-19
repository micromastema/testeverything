package com.zheng.testeverything.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author zhengchentong on 2019/12/19
 */
@Getter
@Setter
public class MongoStudyRecordEntity {
    @Id
    private String id;
    private Integer growValue;
    private List<MogodbChannelRecordEntity> channelRecords;
    private LinkedHashMap<Integer,Integer> learntDayCount;

}
