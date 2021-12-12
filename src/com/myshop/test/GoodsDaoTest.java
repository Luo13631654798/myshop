package com.myshop.test;

import com.myshop.dao.GoodsDao;
import com.myshop.dao.impl.GoodsDaoImpl;
import com.myshop.pojo.Goods;
import com.myshop.pojo.Page;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoodsDaoTest {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    @Test
    void addGoods() {
        goodsDao.addGoods(new Goods(null,"饼干","食品",new BigDecimal(10),20,30,null));
    }

    @Test
    void deleteGoods() {
        goodsDao.deleteGoods(8);
    }

    @Test
    void updateGoods() {
        goodsDao.updateGoods(new Goods(9,"面包","食品",new BigDecimal(500),20,30,null));
    }

    @Test
    void queryGoodsById() {
        System.out.println(goodsDao.queryGoodsById(5));
    }

    @Test
    void queryGoods() {
        for (Goods queryGood : goodsDao.queryGoods()) {
            System.out.println(queryGood);
        }
    }
    @Test
    public void queryForPageItems() {
        for (Goods goods : goodsDao.queryForPageItems(8, Page.PAGE_SIZE)) {
            System.out.println(goods);
        }
    }
    @Test
    public void queryForPageItemsByKey() {
        for (Goods goods : goodsDao.queryForPageItemsByKey(0, Page.PAGE_SIZE,"%上衣%")) {
            System.out.println(goods);
        }
    }
    @Test
    public void queryForPageTotalCount() {
        System.out.println(goodsDao.queryForPageTotalCount());
    }
    @Test
    public void queryForPageTotalCountByKey() {
        System.out.println(goodsDao.queryForPageTotalCountByKey("上衣"));
    }

}