package com.myshop.web;

import com.myshop.pojo.Cart;
import com.myshop.pojo.CartItem;
import com.myshop.pojo.Goods;
import com.myshop.service.GoodsService;
import com.myshop.service.impl.GoodsServiceImpl;
import com.myshop.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet",value = "/cartServlet")
public class CartServlet extends BaseServlet {
    private GoodsService goodsService = new GoodsServiceImpl();
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Goods goods = goodsService.queryGoodsById(id);

        CartItem cartItem = new CartItem(goods.getId(),goods.getName(),1,goods.getPrice(),goods.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart==null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        cart.addItem(cartItem);
        req.getSession().setAttribute("lastname",cartItem.getName());
        resp.sendRedirect(req.getHeader("Referer"));

    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.deleteItem(id);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.updateCount(id,count);
        }
        resp.sendRedirect(req.getHeader("Referer"));

    }
}
