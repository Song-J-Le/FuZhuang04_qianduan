package com.cn.wanxi.model;

public class NewsModel {
    private Integer id;

    private String title;
    private String content;
    private String createTime;
    private Integer newsStyleId;
    private String newsStyleName;
    private Integer limit;
    private Integer page;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getNewsStyleId() {
        return newsStyleId;
    }

    public void setNewsStyleId(Integer newsStyleId) {
        this.newsStyleId = newsStyleId;
    }

    public String getNewsStyleName() {
        return newsStyleName;
    }

    public void setNewsStyleName(String newsStyleName) {
        this.newsStyleName = newsStyleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
