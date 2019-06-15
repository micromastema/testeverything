package com.zheng.testeverything.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author zhengchentong on 2019-06-15
 */
@Configuration //注册到springboot 容器中
@MapperScan(basePackages = "com.zheng.testeverything.model2", sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class DataSourceConfig2 {

    @Autowired
    private DataSourceConfig2.IDataSourceProperties iDataSourceProperties;

    @Bean(name = "test2DataSource")
    public DataSource testDataSource() {
        MysqlXADataSource mysqlXaDataSource2 = new MysqlXADataSource();
        mysqlXaDataSource2.setUrl(iDataSourceProperties.getUrl());
        mysqlXaDataSource2.setUser(iDataSourceProperties.getUsername());
        mysqlXaDataSource2.setPassword(iDataSourceProperties.getPassword());

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource2);
        xaDataSource.setUniqueResourceName("test2DataSource");
        return xaDataSource;
    }

    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Component
    @ConfigurationProperties(prefix = "spring.datasource.d2")
    @Data
    class IDataSourceProperties {
        private String url;
        private String username;
        private String password;
        private String driverClassName;
    }

}
