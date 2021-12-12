package com.myshop.dao;

import com.myshop.pojo.Order;

import java.util.List;

public interface OrderDao {
    public int saveOrder(Order order);
    public List<Order> queryOrderById(Integer id);
    public List<Order> queryAllOrder();
    public int updateStatusTo1(String id);
    public int updateStatusTo2(String id);


}
