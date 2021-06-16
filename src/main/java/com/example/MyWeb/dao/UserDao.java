package com.example.MyWeb.dao;

import com.example.MyWeb.entity.User;

import java.util.List;
import java.util.List;

public interface UserDao {


    User login(User user);//登录

    int register(User user);//注册

    User viewUser(String account);//查看当前用户信息

    List<User> viewAllUser();//查询所有用户信息
    int userModify(User user);//修改用户信息
    int deleteUser(String account);//删除用户
    Integer queryNum();//查询总记录数
    List<User> Page(Integer one, Integer pageSize);//查询分页中的数据

}


