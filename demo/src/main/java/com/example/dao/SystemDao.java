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

    /**
     * 根据用户名查询用户
     * @param param request
     * @return int
     */
    int countUserByUsername(Map param);

    /**
     * 根据密码查询用户
     * @param param request
     * @return int
     */
    int countUserByPassword(Map param);
}
