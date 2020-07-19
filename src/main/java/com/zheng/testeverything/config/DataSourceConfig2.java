package com.zheng.testeverything.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author zhengchentong on 2019-06-15
 */
@Configuration //注册到springboot 容器中
@MapperScan(basePackages = "com.zheng.testeverything.model2", sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class DataSourceConfig2 {

    @Bean(name = "test2DataSource")
    @ConfigurationProperties(prefix = "spring.shardingsphere.datasource.database2")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test3DataSource")
    public DataSource dataSource(@Qualifier("test2DataSource") DataSource dataSource) throws SQLException {

        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();

        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("database2", dataSource);

        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration("user", "database2.user_${0..1}");
        // 配置分库 + 分表策略
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "database2"));
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "user_${id % 2}"));

        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);


        // 获取数据源对象
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new Properties());
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("test3DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //加载其他文件，如mapper.xml
        // bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test2/*.xml"));
        return bean.getObject();
    }

    //事务管理
    @Bean
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test3DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
