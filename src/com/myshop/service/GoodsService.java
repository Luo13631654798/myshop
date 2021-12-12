package com.myshop.service;

import com.myshop.pojo.Goods;
import com.myshop.pojo.Page;

import java.util.List;

public interface GoodsService {
    public void addGoods(Goods goods);
    public void deleteGoodsById(Integer id);
    public void updateGoods(Goods goods);
    public Goods queryGoodsById(Integer id);
    public List<Goods> queryGoods();

    Page<Goods> page(int pageNo, int pageSize);

    Page<Goods> pageByKey(int pageNo, int pageSize, String key);
}
