package com.zheng.testeverything;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
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
    private Producer producer;

    @GetMapping("test")
    public String test() {
        Message message = new Message();
        message.setBody("aaa".getBytes());
        message.setTag("TAG_IVYKID");
        message.setTopic("TOPIC_DELAYMESSAGE");
        message.setStartDeliverTime(30000);
        producer.send(message);
        return "s";
    }
}
