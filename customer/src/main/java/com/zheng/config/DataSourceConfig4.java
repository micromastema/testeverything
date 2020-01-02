//package com.zheng.customer.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * @author zhengchentong on 2019-06-15
// */
//@Configuration //注册到springboot 容器中
//@MapperScan(basePackages = "com.zheng.customer.model2", sqlSessionTemplateRef = "test4SqlSessionTemplate")
//public class DataSourceConfig4 {
//
//    @Bean(name = "test4DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.d2")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "test4SqlSessionFactory")
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test4DataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        //加载其他文件，如mapper.xml
//        // bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test2/*.xml"));
//        return bean.getObject();
//    }
//
//    //事务管理
//    @Bean(name = "test4TransactionManager")
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("test4DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "test4SqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test4SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
