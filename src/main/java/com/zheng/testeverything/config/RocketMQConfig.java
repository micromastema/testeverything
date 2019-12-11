package com.zheng.testeverything.config;

import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.bean.ConsumerBean;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author zhengct
 * @date 2019/12/8
 */
@Configuration
@Component
public class RocketMQConfig {
    private String producerId = "GID_IVYKID";
    private String consumerId = "GID_IVYKID";
    private String accesskey = "LTAI4Ffsd7EspeKbiNUk3p2S";
    private String secretkey="A4uMfT0c38Cru2ttWMPF2qSGNhekYu";
    private String onsaddr="http://MQ_INST_1034468624965622_BbbC9Tds.cn-hangzhou.mq-internal.aliyuncs.com:8080";

    @Autowired
    private ConsumerListener consumerListener;

    //提供消费者的配置
    Properties getConsumerProperties() {
        Properties consumerProperties = new Properties();
        consumerProperties.setProperty(PropertyKeyConst.ConsumerId, consumerId);
        consumerProperties.setProperty(PropertyKeyConst.AccessKey, accesskey);
        consumerProperties.setProperty(PropertyKeyConst.SecretKey, secretkey);
        consumerProperties.setProperty(PropertyKeyConst.NAMESRV_ADDR, onsaddr);
        return consumerProperties;
    }
    //提供生产者的配置
    Properties getProducerProperties() {
        Properties producerProperties = new Properties();
        producerProperties.setProperty(PropertyKeyConst.ProducerId, producerId);
        producerProperties.setProperty(PropertyKeyConst.AccessKey, accesskey);
        producerProperties.setProperty(PropertyKeyConst.SecretKey, secretkey);
        producerProperties.setProperty(PropertyKeyConst.NAMESRV_ADDR, onsaddr);
        return producerProperties;
    }

    @Bean
    public Producer producer() {
        Producer producer = ONSFactory.createProducer(getProducerProperties());
        producer.start();
        return producer;
    }

    @Bean
    public Consumer consumer() {
        Consumer consumer = ONSFactory.createConsumer(this.getConsumerProperties());
        consumer.subscribe("TOPIC_DELAYMESSAGE", "TAG_IVYKID", consumerListener);
        consumer.start();
        return consumer;
    }

}