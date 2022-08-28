package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.NewsStyleDao;
import com.cn.wanxi.model.NewsStyleModel;
import com.cn.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsStyleImpl implements NewsStyleDao {
    @Override
    public List<NewsStyleModel> getList() {
        String sql = "select * from news_style where enable=1";
        ResultSet resultSet = JDBC.getJdbc().query(sql);
        List<NewsStyleModel> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                NewsStyleModel model = new NewsStyleModel();
                model.setId(resultSet.getInt("id"));
                model.setName(resultSet.getString("name"));
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
