package com.myshop.filter;

import com.myshop.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Object user =httpServletRequest.getSession().getAttribute("user");
        if(user==null){
            httpServletRequest.getRequestDispatcher("/pages/client/cannotmanage.jsp").forward(servletRequest,servletResponse);
        }else {
            User user1 = (User) user;
            if("admin".equals(user1.getUsername())){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                httpServletRequest.getRequestDispatcher("/pages/client/cannotmanage.jsp").forward(servletRequest,servletResponse);
            }

        }
    }

    @Override
    public void destroy() {

    }
}
