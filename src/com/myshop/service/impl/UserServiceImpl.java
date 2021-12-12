package com.myshop.service.impl;

import com.myshop.dao.UserDao;
import com.myshop.dao.impl.UserDaoImpl;
import com.myshop.pojo.User;
import com.myshop.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User loginUser(User user) {
            return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;
        }
        return true;
    }
}

