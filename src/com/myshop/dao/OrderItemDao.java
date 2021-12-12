package com.myshop.dao;

import com.myshop.pojo.Order;
import com.myshop.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);
    public List<OrderItem> queryOrderItemById(String id);

}
