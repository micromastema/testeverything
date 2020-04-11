package com.zheng.testeverything.elasticsearch;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhengct
 * @date 2020/4/11
 */
@Component
public class ElasticSearchService {

    @Autowired
    public ElasticsearchTemplate elasticsearchTemplate;


    public List<Entity> getDoc() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withIndices("test_index")
                .withTypes("type2")
                .withQuery(QueryBuilders.termQuery("openId", "aaa333"))
                .build();
        return elasticsearchTemplate.queryForList(searchQuery, Entity.class);
    }
}
