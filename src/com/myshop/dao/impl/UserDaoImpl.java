package com.myshop.dao.impl;

import com.myshop.dao.UserDao;
import com.myshop.pojo.User;
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql="select id,username,password,email from t_user where username=?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public int saveUser(User User) {
        String sql="INSERT INTO t_user(username,password,email) VALUES(?,?,?)";
        return update(sql,User.getUsername(),User.getPassword(),User.getEmail());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql="select id,username,password,email from t_user where username=? and password=?";
        return queryForOne(User.class,sql,username,password);
    }
}
