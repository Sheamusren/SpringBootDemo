package com.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author sheamus
 * @date 2018/9/11
 */
@Mapper
@Repository
public interface SystemDao {
    /**
     * 获取系统配置信息
     * @return map
     */
    Map getSystemConfig();
}
