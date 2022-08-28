package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.NavDao;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NavImpl implements NavDao {
    @Override
    public List<NavModel> getNavList() {
        String sql = "select * from nav where is_show=1";
        ResultSet resultSet = JDBC.getJdbc().query(sql);
        List<NavModel> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                NavModel model = new NavModel();
                model.setHref(resultSet.getString("href"));
                model.setTitle(resultSet.getString("title"));
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
