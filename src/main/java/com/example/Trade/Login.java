package com.example.Trade;


import com.example.Bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ResourceBundle;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/Login".equals(servletPath)){
            try {
                doLogin(request, response);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, ClassNotFoundException {
        String Account = request.getParameter("username");
        String Password = request.getParameter("password");
        boolean success=false;
        User LoginUser=new User();
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        ResourceBundle bundle=ResourceBundle.getBundle("DB");
        String driver=bundle.getString("driver");
        String url=bundle.getString("url");
        String user=bundle.getString("user");
        String password=bundle.getString("password");
        Class.forName(driver);
        connection= DriverManager.getConnection(url,user,password);
        String sql="select * from manager where account=? and password=?";
        statement=connection.prepareStatement(sql);
        statement.setString(1,Account);
        statement.setString(2,Password);
        resultSet=statement.executeQuery();
        if(resultSet.next()) {
            success=true;
        }
        if(success){
            /*添加session对象，便于后面过滤器的使用*/
           HttpSession session=request.getSession();//如果没有session对象就直接创建一个
           session.setAttribute("username",Account);

           LoginUser.setUsername(Account);
           LoginUser.setPassword(Password);

            //将用户姓名绑定到请求域中，并使用转发机制进行请求转发，跳转到管理页面
            //使用转发机制的原因是用户的头像是动态获取的，直接绑定在了bean对象中
            //登陆成功，转发重定向到/getEmployee进行雇员信息的获取
            request.setAttribute("userinfo",user);
            request.getRequestDispatcher("/getEmployee").forward(request,response);

        }else{
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/error.jsp");
        }
        if(resultSet!=null) {
            resultSet.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(connection!=null) {
            connection.close();
        }

    }
}
