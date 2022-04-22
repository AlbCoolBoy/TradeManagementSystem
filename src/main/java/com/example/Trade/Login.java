package com.example.Trade;

import com.example.DButil.Util;
import com.example.ManagerInfo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/Login".equals(servletPath)){
            try {
                doLogin(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean success=false;
        User user=new User();

        //登录验证
        PreparedStatement statement =null;
        Connection connection= Util.getconnection();
        ResultSet resultSet=null;
        String sql="select * from manager where fname=? and password=?";
        statement=connection.prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,password);
        resultSet=statement.executeQuery();
        while(resultSet.next()) {
           success=true;
        }
        if(success){
            user.setUsername(username);
            user.setPassword(password);
            //将用户姓名绑定到请求域中，并使用转发机制进行请求转发，跳转到管理页面
            request.setAttribute("userinfo",user);
            request.getRequestDispatcher("/Panel.jsp").forward(request,response);
        }else{
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/error.jsp");
        }

    }
}
