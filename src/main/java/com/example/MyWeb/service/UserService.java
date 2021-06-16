package com.example.MyWeb.service;

import com.example.MyWeb.dao.UserDao;
import com.example.MyWeb.entity.User;
import com.example.MyWeb.utils.PageBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //注入dao
    @Autowired
    private UserDao dataDao;

    public User userLogin(User user) {
        return dataDao.login(user);
    }

    public int userRegister(User user) {
        return dataDao.register(user);
    }
    public User viewUser(String account) {
        return dataDao.viewUser(account);
    }
    public List<User> viewAllUser(){
        return dataDao.viewAllUser();
    }
    public int userModify(User user){
        return dataDao.userModify(user);
    }
    public int deleteUser(String account){
        return dataDao.deleteUser(account);
    }
    public PageBeanUtil<User> querypage(Integer localPage){
        if (localPage == null) { // 解决空指针异常问题
            localPage = 1;
        }
        Integer totalNum = dataDao.queryNum();
        PageBeanUtil<User> pageBeanUtil = new PageBeanUtil<>(localPage, totalNum);
        Integer one = (localPage - 1) * pageBeanUtil.getPageSize();// 分页两个参数中的第一个
        List<User> list = dataDao.Page(one, pageBeanUtil.getPageSize());
        pageBeanUtil.setList(list);
        return pageBeanUtil;
    }
}
