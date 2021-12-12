package com.myshop.test;

import com.myshop.dao.OrderDao;
import com.myshop.dao.impl.OrderDaoImpl;
import com.myshop.pojo.Order;
import com.myshop.pojo.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OrderDaoTest {

    @Test
    void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("456",new Date(),new BigDecimal(100),0,1));
    }
    @Test
    void queryOrderById() {
        OrderDao orderDao = new OrderDaoImpl();
        for (Order order : orderDao.queryOrderById(21)) {
            System.out.println(order);
        }
    }
    @Test
    void updateStatusById() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.updateStatusTo1("163808199414621");
    }
    @Test
    void queryOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        for (Order order : orderDao.queryAllOrder()) {
            System.out.println(order);
        }
    }
}