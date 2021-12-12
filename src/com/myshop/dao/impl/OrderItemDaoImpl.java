package com.myshop.dao.impl;

import com.myshop.dao.OrderItemDao;
import com.myshop.pojo.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(NAME,COUNT,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemById(String id) {
        String sql = "select NAME,COUNT,price,total_price totalPrice,order_id orderId from t_order_item where order_id=?";
        return queryForList(OrderItem.class,sql,id);
    }
}
