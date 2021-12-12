package com.myshop.web;

import com.myshop.pojo.Cart;
import com.myshop.pojo.Order;
import com.myshop.pojo.OrderItem;
import com.myshop.pojo.User;
import com.myshop.service.OrderService;
import com.myshop.service.impl.OrderServiceImpl;
import com.myshop.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet",value = "/orderServlet")
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginuser = (User) req.getSession().getAttribute("user");

        if (loginuser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = loginuser.getId();
        String order = orderService.createOrder(cart, userId);


        req.getSession().setAttribute("orderId",order);

        resp.sendRedirect("pages/cart/checkout.jsp");
    }

    protected void queryMyOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Order> myOrder = orderService.queryMyOrder(user.getId());
        req.getSession().setAttribute("myOrder",myOrder);
        resp.sendRedirect("pages/order/order.jsp");
    }
    protected void queryOrderDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderid = req.getParameter("orderid");
        System.out.println(orderid);;
        List<OrderItem> orderItemsList = orderService.queryOrderItemById(orderid);
        System.out.println(orderItemsList);
        req.setAttribute("orderItemsList",orderItemsList);
        req.getRequestDispatcher("/pages/order/order_item.jsp").forward(req,resp);
    }
    protected void queryAllOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Order> orderList = orderService.queryAllOrder();

        req.setAttribute("orderList",orderList);
        req.getRequestDispatcher("/pages/manager/order.jsp").forward(req,resp);
    }
    protected void sendout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String orderid = req.getParameter("orderid");
        orderService.sendout(orderid);
        resp.sendRedirect(req.getContextPath()+"/orderServlet?action=queryAllOrder");
    }
    protected void confirm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String orderid = req.getParameter("orderid");
        orderService.confirm(orderid);
        resp.sendRedirect(req.getContextPath()+"/orderServlet?action=queryMyOrder");
    }
}
