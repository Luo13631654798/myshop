package com.myshop.test;

import com.myshop.pojo.Cart;
import com.myshop.pojo.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"goods1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"goods1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"goods2",1,new BigDecimal(2000),new BigDecimal(2000)));
        System.out.println(cart);
    }

    @Test
    void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"goods1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"goods1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"goods2",1,new BigDecimal(2000),new BigDecimal(2000)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"goods1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"goods1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"goods2",1,new BigDecimal(2000),new BigDecimal(2000)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"goods1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"goods1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"goods2",1,new BigDecimal(2000),new BigDecimal(2000)));
        cart.updateCount(1,10);
        System.out.println(cart);
    }
}