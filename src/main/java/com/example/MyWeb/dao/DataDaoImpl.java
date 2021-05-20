package com.example.MyWeb.dao;

import com.example.MyWeb.entity.User;
import com.example.MyWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Repository
public class DataDaoImpl implements DataDao {
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int login(User user) {
//        System.out.println(jdbcTemplate);
        String sql = "select * from user_info ";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
//        List<String> users = jdbcTemplate.query(sql, new RowMapper<String>());
        for (User u : users
        ) {
            System.out.println(u.getAccount());
            System.out.println(u.getPassWord());
            if(user.getAccount().equals(u.getAccount()) && user.getPassWord().equals(u.getPassWord())){
                System.out.println("登陆成功");
                return 1;
            }
        }
        System.out.println("您输入的账号或者密码有误！如果没有账号请注册");
        return 0;
    }

    @Override
    public int register(User user) {
        String sql = "select * from user_info ";//查询数据库账号信息比对
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));

        for(User u : users){
            if(u.getAccount().equals(user.getAccount())){
                System.out.println("账号已存在!");
                return 0;
            }
        }
        String sq = "insert into user_info values(?,?)";//插入的数据
        Object[] args = {user.getAccount(), user.getPassWord()};
        int update = jdbcTemplate.update(sq, args);
        System.out.println(update);
        return 1;
    }
}
