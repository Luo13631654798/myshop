package com.myshop.dao.impl;

import com.myshop.dao.GoodsDao;
import com.myshop.pojo.Goods;

import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    @Override
    public int addGoods(Goods goods) {
        String sql = "INSERT INTO t_goods(NAME,price,kind,sales,stock,img_path) VALUES(?,?,?,?,?,?)";
        return update(sql,goods.getName(),goods.getPrice(),goods.getKind(),goods.getSales(),goods.getStock(),goods.getImgpath());
    }

    @Override
    public int deleteGoods(Integer id) {
        String sql = "delete from t_goods where id=?";
        return update(sql,id);
    }

    @Override
    public int updateGoods(Goods goods) {
        String sql = "update t_goods set NAME=?,price=?,kind=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql,goods.getName(),goods.getPrice(),goods.getKind(),goods.getSales(),goods.getStock(),goods.getImgpath(),goods.getId());
    }

    @Override
    public Goods queryGoodsById(Integer id) {
        String sql = "select id,NAME,price,kind,sales,stock,img_path imgpath from t_goods where id=?";
        return queryForOne(Goods.class,sql,id);
    }

    @Override
    public List<Goods> queryGoods() {
        String sql = "select id,NAME,price,kind,sales,stock,img_path imgpath from t_goods";
        return queryForList(Goods.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_goods";
        Number count = (Number) quertForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public Integer queryForPageTotalCountByKey(String key) {
        String sql = "select count(*) from t_goods where name like ?";
        Number count = (Number) quertForSingleValue(sql,key);
        return count.intValue();
    }

    @Override
    public List<Goods> queryForPageItemsByKey(int begin, int pageSize, String key) {
        String sql = "select id,NAME,price,kind,sales,stock,img_path imgpath from t_goods where name like ? order by sales DESC limit ?,? ";
        return queryForList(Goods.class,sql,key,begin,pageSize);
    }

    @Override
    public List<Goods> queryForPageItems(int begin, int pageSize) {
        String sql = "select id,NAME,price,kind,sales,stock,img_path imgpath from t_goods limit ?,?";
        return queryForList(Goods.class,sql,begin,pageSize);
    }
}
