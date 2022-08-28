package com.cn.wanxi.model;

public class NavModel  {

    private String href;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "NavModel{" +
                "href='" + href + '\'' +
                '}';
    }

}
