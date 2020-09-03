package com.zheng.testeverything.service;

import com.zheng.testeverything.base.OrderBean;
import com.zheng.testeverything.base.Page;
import com.zheng.testeverything.base.PageList;
import com.zheng.testeverything.mapper.LogMapper;
import com.zheng.testeverything.model.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengchentong on 2019/11/6
 */
@Service
public class LogService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LogMapper logMapper;

    /**
     * 根据id获取
     *
     * @param id id
     * @return Log
     */
    public Log findById(Long id) {
        return logMapper.findById(id);
    }

    /**
     * 新增一条数据
     *
     * @param log log
     * @return int
     */
    public int insert(Log log) {
        return logMapper.insert(log);
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return int
     */
    public int deleteById(Long id) {
        return logMapper.deleteById(id);
    }

    /**
     * 根据id更新
     *
     * @param log log
     * @return int
     */
    public int updateById(Log log) {
        return logMapper.updateById(log.getId(), log);
    }

    /**
     * 查找列表
     *
     * @param log       log
     * @param page      page
     * @param orderBean orderBean
     * @return PageList<Log>
     */
    public PageList<Log> findByExamplePage(Log log, Page page, OrderBean orderBean) {
        List<Log> logList = logMapper.findByExample(log, page, orderBean);
        int totalCount = logMapper.findByExampleCount(log);
        page.setTotalCount(totalCount);
        return new PageList<>(logList, page);
    }
}

