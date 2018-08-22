package com.example.task;

import com.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configurable
public class UserTask {

    @Autowired
    UserDao userDao;

    @Scheduled(cron = "0 15 3 * * ?")
    public void removeRepeatUser(){
        userDao.removeRepeatUser();
    }
}
