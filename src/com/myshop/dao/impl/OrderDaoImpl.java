package com.myshop.dao.impl;

import com.myshop.dao.OrderDao;
import com.myshop.pojo.Goods;
import com.myshop.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,STATUS,user_id) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrderById(Integer id) {
        String sql = "select order_id orderId,create_time createTime,price,STATUS,user_id userId from t_order where user_id=?";
        return queryForList(Order.class,sql,id);
//        String sql = "select id,NAME,price,kind,sales,stock,img_path imgpath from t_goods where id=?";
//        return queryForOne(Goods.class,sql,id);
    }

    @Override
    public List<Order> queryAllOrder() {
        String sql = "select order_id orderId,create_time createTime,price,STATUS,user_id userId from t_order";
        return queryForList(Order.class,sql);
    }

    @Override
    public int updateStatusTo1(String id) {
        String sql = "update t_order set status=1 where order_id=?";
        return update(sql,id);
    }

    @Override
    public int updateStatusTo2(String id) {
        String sql = "update t_order set status=2 where order_id=?";
        return update(sql,id);
    }
}
