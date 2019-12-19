package com.zheng.testeverything.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

/**
 * @author zhengchentong on 2019/12/19
 */
@Setter
@Getter
public class MogodbChannelRecordEntity {
    private Integer channelId;
    private Instant studyTime;
    private Instant startTime;
    private Instant endTime;
    private Instant commitTime;
    private Integer timeLength;
    private String isSameDay;
    private String courseName;
    private Integer courseId;
}
