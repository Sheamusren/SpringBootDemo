package com.example.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author sheamus
 * @date 2018.8.14
 */
@Mapper
@Repository
public interface UserDao {
	/**
	 * 获取用户列表
	 * @return list
	 */
	List<Map<String,Object>> listUser();

	/**
	 * 保存用户
	 * @param param
	 */
	void saveUser(Map<String, Object> param);

	/**
	 * 验证用户是否存在
	 * @param param
	 * @return int
	 */
	int countUser(Map<String, Object> param);

	/**
	 *删除重复数据
	 */
	void removeRepeatUser();
}
