package com.zheng.testeverything.config;

import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlXADataSource;


/**
 * @author zhengchentong on 2019-06-15
 */
@Configuration
@MapperScan(basePackages = "com.zheng.testeverything.model1", sqlSessionTemplateRef = "test1SqlSessionTemplate")
public class DataSourceConfig1 {

    @Autowired
    private IDataSourceProperties iDataSourceProperties;

    @Bean(name = "test1DataSource")
    public DataSource testDataSource() {
        MysqlXADataSource mysqlXaDataSource1 = new MysqlXADataSource();
        mysqlXaDataSource1.setUrl(iDataSourceProperties.getUrl());
        mysqlXaDataSource1.setUser(iDataSourceProperties.getUsername());
        mysqlXaDataSource1.setPassword(iDataSourceProperties.getPassword());

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource1);
        xaDataSource.setUniqueResourceName("test1DataSource");
        return xaDataSource;
    }

    @Bean(name = "test1SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "test1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Component
    @ConfigurationProperties(prefix = "spring.datasource.d1")
    @Data
    class IDataSourceProperties {
        private String url;
        private String username;
        private String password;
        private String driverClassName;
    }

}
