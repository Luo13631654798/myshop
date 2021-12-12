package com.myshop.service;

import com.myshop.pojo.Cart;
import com.myshop.pojo.Order;
import com.myshop.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    public String createOrder(Cart cart,Integer userid);
    public List<Order> queryMyOrder(Integer userid);
    public List<OrderItem> queryOrderItemById(String id);
    public List<Order> queryAllOrder();
    public void sendout(String id);
    public void confirm(String id);
}
