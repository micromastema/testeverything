package com.zheng.testeverything;

import com.aliyun.mq.http.MQProducer;
import com.aliyun.mq.http.model.Message;
import com.aliyun.mq.http.model.TopicMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengchentong on 2019-06-15
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private MQProducer mqProducer;

    private String topic = "TOPIC_DELAYMESSAGE_TEST";
    private String tag = "TAG_IVYKID";

    @GetMapping("test")
    public String test() {
        TopicMessage message = new TopicMessage();
        message.setMessageKey("key");
        message.setMessageTag(tag);
        message.setStartDeliverTime(System.currentTimeMillis() + 5000);
        message.setMessageBody("aaa".getBytes());
        message.setMessageId("id");
        mqProducer.publishMessage(message);
        System.out.println("发送");
        return "s";
    }
}
