package com.zheng.testeverything.rocketmq;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author zhengct
 * @date 2020/4/11
 */
@Component
public class Produce {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RocketMQTemplate rocketMqTemplate;

    public void run() {
        rocketMqTemplate.convertAndSend("topic_test", "message");
        System.out.println("send finished!");
    }

    public void sendDelayMessage() {
        Message<String> message = MessageBuilder.withPayload("a").build();
        //同步
        SendResult o = rocketMqTemplate.syncSend("topic_test", message, 1000, 3);
        System.out.println(o.getSendStatus());
        //异步
        rocketMqTemplate.asyncSend("topic_test", message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("send successful");
            }

            @Override
            public void onException(Throwable throwable) {
                log.info("send fail; {}", throwable.getMessage());
            }
        }, 1000, 3);
    }
}
