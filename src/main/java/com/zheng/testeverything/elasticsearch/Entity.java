package com.zheng.testeverything.elasticsearch;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhengct
 * @date 2020/4/11
 */
@Data
@Document(indexName = "test_index")
@ToString
public class Entity implements Serializable {
    @Id
    private String openId;
    private Date optDt;
    private String parentChannelId;
    private String viewCode;
    private String optKeys;
    private String isDistribution;
    private String isSpecial;
    private String goodsId;
    private String priceId;
    private String text;
    private Integer price;

}