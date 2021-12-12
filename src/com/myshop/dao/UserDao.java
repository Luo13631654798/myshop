package com.myshop.dao;

import com.myshop.pojo.User;

public interface UserDao {
    public User queryUserByUsername(String username);
    public int saveUser(User User);
    public User queryUserByUsernameAndPassword(String username,String password);


}
