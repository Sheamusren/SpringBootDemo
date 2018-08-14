package com.example.service;

import java.util.List;
import java.util.Map;

/**
 * @author sheamus
 * @date 2018.8.14
 */
public interface UserService {
	/**
	 * 获取用户列表
	 * @return
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
	 * @return
	 */
	int countUser(Map<String, Object> param);
}
