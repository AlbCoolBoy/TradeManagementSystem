package com.example.Trade;

import com.example.DButil.Util;

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

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String useername = request.getParameter("useername");
        String password = request.getParameter("password");
        boolean success=false;

        PreparedStatement statement =null;
        Connection connection= Util.getconnection();
        ResultSet resultSet=null;
        String sql="select * from employee where fname=? and password=?";
        connection.prepareStatement(sql);
        statement.setString(1,useername);
        statement.setString(2,password);
        resultSet=statement.executeQuery();
        while(resultSet.next()) {
           success=true;
        }
        if(success){
            response.sendRedirect("/Panel.jsp");
        }

    }
}
