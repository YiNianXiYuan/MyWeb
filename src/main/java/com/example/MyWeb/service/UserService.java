package com.example.MyWeb.service;

import com.example.MyWeb.dao.DataDao;
import com.example.MyWeb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //注入dao
    @Autowired
    private DataDao dataDao;

    public int userLogin(User user) {
        return dataDao.login(user);
    }

    public int userRegister(User user) {
        return dataDao.register(user);
    }

//    public void userCancellation(User user) {
//        dataDao.cancellation(user);
//    }
}
