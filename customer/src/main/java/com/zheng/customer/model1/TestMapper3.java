package com.zheng.customer.model1;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhengchentong on 2019-06-14
 */
@Mapper
public interface TestMapper3 {

    @Select("select teacher from t1 where username = #{username}")
    String getid(String username);

}