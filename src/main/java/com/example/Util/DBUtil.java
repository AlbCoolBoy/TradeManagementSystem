package com.example.Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

//数据库操作工具类
public class DBUtil {
    private static DataSource dataSource;


    //注册驱动
    static {

        try {
            InputStream resource = DBUtil.class.getClassLoader().getResourceAsStream("druid.properties");

            Properties properties = new Properties();
            properties.load(resource);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取连接
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //归还连接
    public static void close(Connection connection,
                             PreparedStatement statement,
                             ResultSet resultSet) throws SQLException {
        if(resultSet!=null){
            resultSet.close();
        }
        if(statement!=null) {
            statement.close();
        }
        if(connection!=null){
            connection.close();
        }

    }

}
