package com.myshop.pojo;

import java.math.BigDecimal;

public class Goods {
    private Integer id;
    private String name;
    private String kind;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
//    private String imgpath="static/img/default.jpg";
    private String imgpath;


    public Goods() {
    }

    public Goods(Integer id, String name, String kind, BigDecimal price, Integer sales, Integer stock, String imgpath) {

        this.id = id;
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.imgpath = imgpath;

//        if(imgpath!=null&& !"".equals(imgpath)){
//            this.imgpath = imgpath;
//        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
//        if(imgpath!=null&&"".equals(imgpath)){
//        this.imgpath = imgpath;
//        }
        this.imgpath = imgpath;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgpath='" + imgpath + '\'' +
                '}';
    }

}
