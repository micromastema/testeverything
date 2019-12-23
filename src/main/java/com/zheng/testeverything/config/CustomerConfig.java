package com.zheng.testeverything.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * @author Riky Li
 * @create 2018-03-21 14:04:17
 * @desciption:
 */
@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb.customer")
public class CustomerConfig extends AbstractMongoConfig {
    //设置为默认数据源，如果定义mongoTemplate的时候未指定数据源，将默认为此数据源
    @Primary
    @Override
    @Bean(name = "customerMongoTemplate")
    public MongoTemplate getMongoTemplate(MongoMappingContext context) throws Exception {
        //去除保存实体时，spring data mongodb 自动添加的_class字段
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory()), context);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return new MongoTemplate(mongoDbFactory(), converter);
    }
}