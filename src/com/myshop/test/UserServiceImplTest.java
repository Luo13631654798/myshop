package com.myshop.test;

import com.myshop.pojo.User;
import com.myshop.service.UserService;
import com.myshop.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

class UserServiceImplTest {
    UserService userService = new UserServiceImpl();

    @Test
    void registUser() {
        userService.registUser(new User(4,"admin4","admin4","admin4@qq.com"));
    }

    @Test
    void loginUser() {
        userService.loginUser(new User(3,"admin3","admin3","admin3@qq.com"));
    }

    @Test
    void existUsername() {
        if(userService.existUsername("admin2")==true){
            System.out.println("exist");
        }
    }
}