package com.myshop.web;

import com.myshop.pojo.User;
import com.myshop.service.UserService;
import com.myshop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/loginServlet")
public class LoginServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.loginUser(new User(null, username, password, null));
        if(loginUser==null){
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);

        }else {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }

    }
}
