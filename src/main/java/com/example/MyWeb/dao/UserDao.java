package com.example.MyWeb.dao;

import com.example.MyWeb.entity.User;

public interface UserDao {
    User login(User user);//登录
    int register(User user);//注册
}
