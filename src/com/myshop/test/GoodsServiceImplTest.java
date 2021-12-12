package com.myshop.test;

import com.myshop.pojo.Goods;
import com.myshop.service.GoodsService;
import com.myshop.service.impl.GoodsServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class GoodsServiceImplTest {
    GoodsService goodsService = new GoodsServiceImpl();
    @Test
    void addGoods() {
        goodsService.addGoods(new Goods(null,"蛋糕","食品",new BigDecimal(100),200,300,null));
    }

    @Test
    void deleteGoodsById() {
        goodsService.deleteGoodsById(9);
    }

    @Test
    void updateGoods() {
        goodsService.updateGoods(new Goods(10,"蛋糕","食品",new BigDecimal(1000),2000,3000,null));
    }

    @Test
    void queryGoodsById() {
        System.out.println(goodsService.queryGoodsById(10));
    }

    @Test
    void queryGoods() {
        System.out.println(goodsService.queryGoods());
    }
    @Test
    void page(){
        System.out.println(goodsService.page(1,4));
    }
    @Test
    void pageByKey(){
        System.out.println(goodsService.pageByKey(1,4,"%上衣%"));
    }
}