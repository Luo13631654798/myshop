package com.myshop.test;

import com.myshop.pojo.Cart;
import com.myshop.pojo.CartItem;
import com.myshop.service.OrderService;
import com.myshop.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {

        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"goods1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"goods1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"goods2",1,new BigDecimal(2000),new BigDecimal(2000)));

        System.out.println(orderService.createOrder(cart,1));
    }
    @Test
    void queryMyOrder() {
        System.out.println(orderService.queryMyOrder(21));
    }
    @Test
    void queryOrderItemByID() {
        System.out.println(orderService.queryOrderItemById("163763657011021"));
    }
    @Test
    void queryAllOrder() {
        System.out.println(orderService.queryAllOrder());
    }
}