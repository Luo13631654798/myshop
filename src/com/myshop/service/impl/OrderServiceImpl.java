package com.myshop.service.impl;

import com.myshop.dao.GoodsDao;
import com.myshop.dao.OrderDao;
import com.myshop.dao.OrderItemDao;
import com.myshop.dao.impl.GoodsDaoImpl;
import com.myshop.dao.impl.OrderDaoImpl;
import com.myshop.dao.impl.OrderItemDaoImpl;
import com.myshop.pojo.*;
import com.myshop.service.OrderService;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();
    private GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis()+""+userId;
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);
        for (CartItem item : cart.getItems().values()) {
            OrderItem orderItem = new OrderItem(null,item.getName(),item.getCount(),item.getPrice(),item.getTotalPrice(),orderId);

            orderItemDao.saveOrderItem(orderItem);
            Goods goods = goodsDao.queryGoodsById(item.getId());
            goods.setSales(goods.getSales()+orderItem.getCount());
            goods.setStock(goods.getStock()-orderItem.getCount());
            goodsDao.updateGoods(goods);

        }
        cart.clear();

        return orderId;
    }

    @Override
    public List<Order> queryMyOrder(Integer userid) {
        return orderDao.queryOrderById(userid);

    }

    @Override
    public List<OrderItem> queryOrderItemById(String id) {
        return orderItemDao.queryOrderItemById(id);
    }

    @Override
    public List<Order> queryAllOrder() {
        return orderDao.queryAllOrder();
    }

    @Override
    public void sendout(String id) {
        orderDao.updateStatusTo1(id);
    }

    @Override
    public void confirm(String id) {
        orderDao.updateStatusTo2(id);

    }
}
