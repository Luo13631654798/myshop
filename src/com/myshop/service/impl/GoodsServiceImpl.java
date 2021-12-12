package com.myshop.service.impl;

import com.myshop.dao.GoodsDao;
import com.myshop.dao.impl.GoodsDaoImpl;
import com.myshop.pojo.Goods;
import com.myshop.pojo.Page;
import com.myshop.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

    @Override
    public void deleteGoodsById(Integer id) {
        goodsDao.deleteGoods(id);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }

    @Override
    public Goods queryGoodsById(Integer id) {
        return goodsDao.queryGoodsById(id);
    }

    @Override
    public List<Goods> queryGoods() {
        return goodsDao.queryGoods();
    }

    @Override
    public Page<Goods> page(int pageNo, int pageSize) {
        Page<Goods> page = new Page<Goods>();

        Integer pageTotalCount = goodsDao.queryForPageTotalCount();
        page.setPageToalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        page.setPageTotal(pageTotal);

        page.setPageSize(pageSize);

        page.setPageNo(pageNo);


        int begin = (page.getPageNo()-1)*pageSize;
        List<Goods> items = goodsDao.queryForPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Goods> pageByKey(int pageNo, int pageSize, String key) {
        Page<Goods> page = new Page<Goods>();

        Integer pageTotalCount = goodsDao.queryForPageTotalCountByKey(key);
        page.setPageToalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        page.setPageTotal(pageTotal);

        page.setPageSize(pageSize);

        page.setPageNo(pageNo);


        int begin = (page.getPageNo()-1)*pageSize;
        List<Goods> items = goodsDao.queryForPageItemsByKey(begin,pageSize,key);
        page.setItems(items);
        return page;
    }
}
