package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.CompanyDao;
import com.cn.wanxi.model.CompanyModel;
import com.cn.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyImpl implements CompanyDao {
    @Override
    public CompanyModel getCompanyModel() {
        String sql="select * from company where is_show=1";
        ResultSet resultSet= JDBC.getJdbc().query(sql);
        CompanyModel companyModel=null;
        try {
            while (resultSet.next()){
                companyModel=new CompanyModel();
                companyModel.setLinePhone(resultSet.getString("line_phone"));
                companyModel.setNet(resultSet.getString("net"));
                companyModel.setLogo(resultSet.getString("logo"));
                companyModel.setPhone(resultSet.getString("phone"));
                companyModel.setEmail(resultSet.getString("email"));
                companyModel.setAddress(resultSet.getString("address"));
                companyModel.setVersion(resultSet.getString("version"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companyModel;
    }
}
