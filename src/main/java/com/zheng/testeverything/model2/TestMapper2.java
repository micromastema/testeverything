package com.zheng.testeverything.model2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhengchentong on 2019-06-14
 */
@Mapper
public interface TestMapper2 {

    @Select("select username from user where id = #{id}")
    String getid(int id);

    /**
     * aa
     */
    @Insert("INSERT INTO `user` (`id`, `username`) VALUES (#{id},#{username})")
    void insert(int id, String username);

}
