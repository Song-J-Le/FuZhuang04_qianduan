package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.NewsStyleDao;
import com.cn.wanxi.dao.impl.NewsStyleImpl;
import com.cn.wanxi.model.NewsStyleModel;
import com.cn.wanxi.service.NewsStyleService;

import java.util.List;

public class NewsStyleServiceImpl implements NewsStyleService {
    @Override
    public List<NewsStyleModel> getList() {
        NewsStyleDao newsStyleDao=new NewsStyleImpl();
        return newsStyleDao.getList();
    }
}
