package com.zheng.testeverything.mapper;

import com.zheng.testeverything.base.OrderBean;
import com.zheng.testeverything.base.Page;
import com.zheng.testeverything.model.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 日志表
 *
 * @author zhengchentong on 2019/10/21
 */
@Mapper
@Component
public interface LogMapper {

    /**
     * @param log log
     * @return 1插入成功 0插入失败
     */
    Integer insert(Log log);

    /**
     * 批量插入记录
     *
     * @param list list
     * @return 1插入成功 0插入失败
     */
    Integer insertBatch(List<Log> list);

    /**
     * 按id删除
     *
     * @param id id
     * @return int
     */
    Integer deleteById(Long id);

    /**
     * 批量删除
     *
     * @param log log
     * @return int
     */
    Integer deleteBatch(Log log);

    /**
     * 根据id更新数据
     *
     * @param id  id
     * @param log log
     * @return int
     */
    Integer updateById(@Param("id") Long id, @Param("log") Log log);

    /**
     * 批量更新数据
     *
     * @param search 条件对象
     * @param value  更新对象
     * @return int
     */
    Integer updateByExample(@Param("value") Log value, @Param("search") Log search);

    /**
     * 根据id查找
     *
     * @param id id
     * @return Log
     */
    Log findById(Long id);

    /**
     * 查找列表总数
     *
     * @param log log
     * @return int 总数
     */
    Integer findByExampleCount(@Param("log") Log log);

    /**
     * 查找列表
     *
     * @param log       log
     * @param page      page
     * @param orderBean orderBean
     * @return List<Log>
     */
    List<Log> findByExample(@Param("log") Log log, @Param("page") Page page, @Param("orderBean") OrderBean orderBean);

    /**
     * 查找列表
     *
     * @param log       log
     * @param page      page
     * @param orderBean orderBean
     * @return List<Log>
     */
    List<Log> findByList(@Param("log") Log log, @Param("column") String column, @Param("valueList") List<Object> valueList, @Param("page") Page page, @Param("orderBean") OrderBean orderBean);
}