package com.example.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserDao uDao;
	
	@Override
	public List<Map<String, Object>> getUser() {
		return uDao.getUser();
	}

}
