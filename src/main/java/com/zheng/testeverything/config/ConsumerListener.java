package com.zheng.testeverything.config;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author zhengchentong on 2019/12/11
 */
@Component
public class ConsumerListener implements MessageListener {
    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        System.out.println(Arrays.toString(message.getBody()));
        System.out.println(message.getTopic());
        return Action.CommitMessage;
    }
}
