package com.cn.wanxi.util;

import java.sql.*;
import java.util.List;

/**
 * 每次调用里面的方法，都会在内存里面开辟空间
 * 只要频繁调用某一个类，我们一般情况下只需要开辟一次空间即可
 * 那么怎么来保证只开劈一次呢？
 * 1.加载驱动
 * 2.得到连接
 * 3.编译sql语句
 * 4.执行sql语句
 * 5.返回结果
 * 6.关闭链接
 */
public class JDBC {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static JDBC jdbc;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    private static Connection connection = null;

    private JDBC() {

    }

    /**
     * 得到链接
     *
     * @return
     */
    private static void getConnection() {
        String url = "jdbc:mysql://localhost:3306/clothes?serverTimezone=UTC&characterEncoding=UTF-8";
        String user = "root";
        String password = "9909";
//        String url = "jdbc:mysql://121.199.55.96:3306/canyin04?serviceTimezone=UTC&characterEncoding=UTF-8";
//        String user = "canyin04";
//        String password = "123456";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {

        }
    }

    public static JDBC getJdbc() {
        if (jdbc == null) {
            jdbc = new JDBC();
        }
        getConnection();
        return jdbc;

    }

    /**
     * 更新数据的链接
     *
     * @param sql
     * @return
     */
    public int update(String sql) {
        try {
//        4.编译sql语句
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        5.执行sql语句
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int update(String sql, List<Object> list) {
        try {
//        4.编译sql语句
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                preparedStatement.setObject(i + 1, list.get(i));
            }
//        5.执行sql语句
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ResultSet query(String sql) {
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet query(String sql, List<Object> list) {
        try {
//            sql语句编译：编译的目的就是将sql语句当中一句不可拆分的
//            所有数据经过编译过后的sql把他当作参数
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                preparedStatement.setObject(i + 1, list.get(i));
            }

            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询总条数
     * @param sql
     * @return
     */
    public int getCount(String sql) {
        ResultSet resultSet = query(sql);
        int count = 0;
        try {
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
