package com.myshop.dao;

import com.myshop.pojo.Goods;

import java.util.List;

public interface GoodsDao {
    public int addGoods(Goods goods);
    public int deleteGoods(Integer id);
    public int updateGoods(Goods goods);
    public Goods queryGoodsById(Integer id);
    public List<Goods> queryGoods();


    Integer queryForPageTotalCount();
    List<Goods> queryForPageItems(int begin,int pageSize);

    Integer queryForPageTotalCountByKey(String key);

    List<Goods> queryForPageItemsByKey(int begin, int pageSize, String key);
}
