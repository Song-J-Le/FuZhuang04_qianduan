package com.cn.wanxi.model;

import java.math.BigDecimal;

public class ProductModel  {
    private BigDecimal price;
    private BigDecimal normalPrice;// Normal_Price 错的
    private String imgHref;//图片地址
    private String content;//描述
    //    描述以后可以会有文字，图片，视频等等;所以，不能用多个属性进行存储，文字只能存放地址
    private Integer cuisineId;
    private String cuisineName;//菜系名称

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(BigDecimal normalPrice) {
        this.normalPrice = normalPrice;
    }

    public String getImgHref() {
        return imgHref;
    }

    public void setImgHref(String imgHref) {
        this.imgHref = imgHref;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Integer cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }
}
