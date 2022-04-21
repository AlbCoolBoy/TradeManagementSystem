package com.example.DButil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/*实现数据库连接的注册驱动和连接的获取*/
public class Util {
    private  Util(){

    }

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getconnection() throws SQLException {
        ResourceBundle bundle=ResourceBundle.getBundle("DB");
        String driver=bundle.getString("driver");
        String url=bundle.getString("url");
        String user=bundle.getString("user");
        String password=bundle.getString("password");
        return DriverManager.getConnection(url,user,password);
    }

}
