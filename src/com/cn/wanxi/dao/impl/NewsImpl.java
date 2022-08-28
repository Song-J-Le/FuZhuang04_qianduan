package com.cn.wanxi.dao.impl;

import com.cn.wanxi.VO.HomeModel;
import com.cn.wanxi.dao.NewsDao;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsImpl implements NewsDao {
    @Override
    public List<NewsModel> getNewsList(HomeModel model) {
        String sql = "select *,date_format(create_time,'%Y-%m-%d') temp from news where where_show=" + model.getNewsWhereShow();
        if (model.getNewsType() != null) {
            sql += " and type=" + model.getNewsType();
        }
        sql += " order by create_time desc ";
        sql += " limit 3 ";
        ResultSet resultSet = JDBC.getJdbc().query(sql);
        List<NewsModel> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                NewsModel newsModel = new NewsModel();
                newsModel.setId(resultSet.getInt("id"));
                newsModel.setTitle(resultSet.getString("title"));
                newsModel.setContent(resultSet.getString("content"));
                newsModel.setCreateTime(resultSet.getString("temp"));
                list.add(newsModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<NewsModel> getNewsDetailList(NewsModel model) {
        String sql = "select * from news where id=(select min(id) from news where id>" + model.getId() + ") " +
                " union all " +
                " select * from  news where id=" + model.getId() +
                " union all  " +
                " select * from news where id=(select max(id) from news where id<" + model.getId() + ") ";
        ResultSet resultSet = JDBC.getJdbc().query(sql);
        List<NewsModel> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                NewsModel newsModel = new NewsModel();
                newsModel.setId(resultSet.getInt("id"));
                newsModel.setTitle(resultSet.getString("title"));
                newsModel.setContent(resultSet.getString("content"));
//                newsModel.setCreateTime(resultSet.getString("temp"));
                list.add(newsModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<NewsModel> getNewsListForNewsPage(NewsModel model) {
        String sql = "select *,date_format(create_time,'%Y-%m-%d') temp from news where 1=1 ";
//        如果前端传递过来的数据为空，那么就查询所有新闻信息
        if (model.getNewsStyleId() != -1) {
            sql += " and type=" + model.getNewsStyleId();
        }
        sql += " order by id desc ";
        int start = (model.getPage() - 1) * model.getLimit();
        sql += " limit " + start + "," + model.getLimit();
        ResultSet resultSet = JDBC.getJdbc().query(sql);
        List<NewsModel> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                NewsModel newsModel = new NewsModel();
                newsModel.setId(resultSet.getInt("id"));
                newsModel.setTitle(resultSet.getString("title"));
                newsModel.setContent(resultSet.getString("content"));
                newsModel.setCreateTime(resultSet.getString("temp"));
                list.add(newsModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
