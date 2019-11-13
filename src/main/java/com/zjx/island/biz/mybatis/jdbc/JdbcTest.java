package com.zjx.island.biz.mybatis.jdbc;

import javax.swing.plaf.TreeUI;
import java.sql.*;

/**
 * 传统jdbc编程
 *
 * @author trevor.zhao
 * @date 2019/11/7
 */
public class JdbcTest {
    public static void main(String[] args) {
        //数据库连接
        Connection connection = null;
        //预编译的Statement,使用预编译的statement提高数据库性能
        PreparedStatement preparedStatement = null;
        //结果集
        ResultSet resultSet = null;

        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            //通过驱动管理类获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://rm-p2u4use9988ufvaec132.mysql.rds.aliyuncs.com:3306/oms?characterEncoding=utf-8", "oms_sit", "AJx678KH");
            //定义sql语句 ?标识占位符
            String sql = "select * from t_monitor_config where monitor_id = ?";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数,第一个为SQL语句中参数的序号(从1开始),第二个为参数的值
            preparedStatement.setString(1, "NB2-datacheck001");
            //发起查询,查出结果集
            resultSet = preparedStatement.executeQuery();
            //遍历结果
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + "  " + resultSet.getString("sqls"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        //释放资源
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
}
