package com.cn.wanxi.service.impl;

import com.cn.wanxi.VO.HomeModel;
import com.cn.wanxi.dao.NewsDao;
import com.cn.wanxi.dao.impl.NewsImpl;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    @Override
    public List<NewsModel> getNewsList(HomeModel model) {
        NewsDao newsDao=new NewsImpl();
        return newsDao.getNewsList(model);
    }

    @Override
    public List<NewsModel> getNewsDetailList(NewsModel model) {
        NewsDao newsDao=new NewsImpl();
        return newsDao.getNewsDetailList(model);
    }

    @Override
    public List<NewsModel> getNewsListForNewsPage(NewsModel newsModel) {
        NewsDao newsDao=new NewsImpl();
        return newsDao.getNewsListForNewsPage(newsModel);
    }
}
