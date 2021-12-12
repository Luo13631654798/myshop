package com.myshop.test;

import com.myshop.dao.OrderItemDao;
import com.myshop.dao.impl.OrderItemDaoImpl;
import com.myshop.pojo.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemDaoTest {
    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null,"鞋子",1,new BigDecimal(500),new BigDecimal(500),"123"));
        orderItemDao.saveOrderItem(new OrderItem(null,"裤子",1,new BigDecimal(500),new BigDecimal(500),"123"));
        orderItemDao.saveOrderItem(new OrderItem(null,"袜子",1,new BigDecimal(500),new BigDecimal(500),"123"));

    }
    @Test
    void queryOrderItemById() {
        for (OrderItem orderItem : orderItemDao.queryOrderItemById("163763657011021")) {
            System.out.println(orderItem);
        }
    }


}