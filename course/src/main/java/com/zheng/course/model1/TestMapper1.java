package com.zheng.course.model1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhengchentong on 2019-06-14
 */
@Mapper
public
interface TestMapper1 {

    @Select("select teacher from t1 where username = #{username}")
    String getid(String username);

}
