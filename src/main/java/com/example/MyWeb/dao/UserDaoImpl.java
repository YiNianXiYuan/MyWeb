package com.example.MyWeb.dao;

import com.example.MyWeb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User login(User user) {
//        System.out.println(jdbcTemplate);
        String sql = "select * from user_info ";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
//        List<String> users = jdbcTemplate.query(sql, new RowMapper<String>());
        for (User u : users
        ) {
//            System.out.println(u.getAccount());
//            System.out.println(u.getPassWord());
//            System.out.println(u.getUsername());
            if(user.getAccount().equals(u.getAccount()) && user.getPassWord().equals(u.getPassWord())){
                System.out.println("登陆成功");
                return u;
            }
        }
        System.out.println("您输入的账号或者密码有误！如果没有账号请注册");
        return null;
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
        String sq = "insert into user_info values(?,?,?)";//插入的数t_book据
        Object[] args = {user.getAccount(), user.getPassWord(), user.getUsername()};
        int update = jdbcTemplate.update(sq, args);
        System.out.println(update);
        return 1;
    }
    @Override
    public User viewUser(String account) {
//        System.out.println(jdbcTemplate);
        String sql = "select * from user_info where account=?";
        //调用方法
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), account);
    }

    @Override
    public List<User> viewAllUser() {
        String sql = "select * from user_info";
        //调用方法
        List<User> userList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public int userModify(User user) {
        String sql = "update user_info set username=?,password=? where account=?";
        Object[] args = {user.getUsername(), user.getPassWord(), user.getAccount()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update+"是否更新成功");
        return update;
    }

    @Override
    public int deleteUser(String account) {
        String sql = "delete from user_info where account=?";
        int update = jdbcTemplate.update(sql, account);
        return update;
    }
    /**
     * 查询总记录数
     */
    @Override
    public Integer queryNum() {
        // TODO Auto-generated method stub
        String sql = "select count(account) from user_info";
        Integer totalNum = jdbcTemplate.queryForObject(sql, Integer.class);
        return totalNum;
    }

    /**
     * 查询分页中的数据
     */
    @Override
    public List<User> Page(Integer one, Integer pageSize) {
        // TODO Auto-generated method stub
        String sql = "select * from user_info limit ?,?";
        List<User> page = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), one,pageSize);
        return page;
    }
}
