package com.cn.wanxi.service;

import com.cn.wanxi.VO.HomeModel;
import com.cn.wanxi.model.NewsModel;

import java.util.List;

public interface NewsService {
    List<NewsModel> getNewsList(HomeModel model);

    List<NewsModel> getNewsDetailList(NewsModel model);

    List<NewsModel> getNewsListForNewsPage(NewsModel newsModel);
}
