package com.myshop.service;

import com.myshop.pojo.User;

public interface UserService {
    public void registUser(User user);
    public User loginUser(User user);
    public boolean existUsername(String username);

}
