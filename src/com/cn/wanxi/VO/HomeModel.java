package com.cn.wanxi.VO;

public class HomeModel {
    private Integer newsWhereShow;
    private Integer productWhereShow;
    private Integer newsLimit;
    private Integer productLimit;
    private Integer newsType;

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public Integer getNewsLimit() {
        return newsLimit;
    }

    public void setNewsLimit(Integer newsLimit) {
        this.newsLimit = newsLimit;
    }

    public Integer getProductLimit() {
        return productLimit;
    }

    public void setProductLimit(Integer productLimit) {
        this.productLimit = productLimit;
    }

    public Integer getNewsWhereShow() {
        return newsWhereShow;
    }

    public void setNewsWhereShow(Integer newsWhereShow) {
        this.newsWhereShow = newsWhereShow;
    }

    public Integer getProductWhereShow() {
        return productWhereShow;
    }

    public void setProductWhereShow(Integer productWhereShow) {
        this.productWhereShow = productWhereShow;
    }
}
