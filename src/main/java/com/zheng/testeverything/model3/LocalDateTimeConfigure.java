package com.zheng.testeverything.model3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//
///**
// * @author zhengchentong on 2019/11/6
// */
//@Configuration
//public class LocalDateTimeConfigure {
//    @Bean(name = "mapperObject")
//    public ObjectMapper getObjectMapper() {
//        return new ObjectMapper().registerModule(new ParameterNamesModule()).registerModule(new Jdk8Module())
//                .registerModule(new JavaTimeModule());
//    }
//}
