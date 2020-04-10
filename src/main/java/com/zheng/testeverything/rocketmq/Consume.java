package com.zheng.testeverything.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author zhengct
 * @date 2020/4/11
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = "topic_test",
        consumerGroup = "test_group"
)
public class Consume implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.info("received message is {}", message);
    }
}
