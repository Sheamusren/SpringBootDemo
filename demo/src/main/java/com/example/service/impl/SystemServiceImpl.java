package com.example.service.impl;

import com.example.dao.SystemDao;
import com.example.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author sheamus
 * @date 2018/9/11.
 */
@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    private SystemDao systemDao;
    @Override
    public Map getSystemConfig() {
        return systemDao.getSystemConfig();
    }
}
