package com.myshop.web;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.myshop.pojo.User;
import com.myshop.service.UserService;
import com.myshop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@WebServlet(name = "UserServlet",value = "/userServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req,HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.loginUser(new User(null, username, password, null));
        if(loginUser==null){
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);

        }else {
            req.getSession().setAttribute("user",loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }

    }
    protected void logout(HttpServletRequest req,HttpServletResponse resp) throws SecurityException, IOException, ServletException {

        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }


        protected void regist(HttpServletRequest req,HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

            String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);

            req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

            if(token.equalsIgnoreCase(code)&&token!=null){
            if (userService.existUsername(username)==true){
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }
            else{
                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);

            }
        }
        else{
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

    }
}
