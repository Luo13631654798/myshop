package com.myshop.test;

import com.myshop.dao.UserDao;
import com.myshop.dao.impl.UserDaoImpl;
import com.myshop.pojo.User;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {

    @org.junit.jupiter.api.Test
    void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("admin1"));
    }

    @org.junit.jupiter.api.Test
    void saveUser() {
        UserDao userDao  = new UserDaoImpl();
        System.out.println(userDao.saveUser(new User(3,"admin3","admin3","admin3@qq.com")));
    }

    @org.junit.jupiter.api.Test
    void queryUserByUsernameAndPassword() {
        UserDao userDao  = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsernameAndPassword("admin3","admin3"));
    }
}