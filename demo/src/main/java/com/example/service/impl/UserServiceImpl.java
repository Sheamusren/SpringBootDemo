package com.example.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.service.UserService;
/**
 * @author sheamus
 * @date 2018.8.14
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
    private UserDao uDao;
	
	@Override
	public List<Map<String, Object>> listUser() {
		return uDao.listUser();
	}

	@Override
	public void saveUser(Map<String, Object> param) {
		uDao.saveUser(param);
	}

	@Override
	public int countUser(Map<String, Object> param) {
		return uDao.countUser(param);
	}

}
