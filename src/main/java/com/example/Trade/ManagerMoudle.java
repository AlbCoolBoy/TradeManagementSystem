package com.example.Trade;

import com.example.Bean.Employee;
import com.example.Bean.EmployeeDetail;
import com.example.Util.DBUtil;

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
import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.info;

@WebServlet({("/getEmployee"), ("/employee/delete"),
        ("/employee/details"), ("/employee/alter"),
        ("/search"), ("alter_receiver"),("/modify")})
public class ManagerMoudle extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/getEmployee".equals(servletPath)) {         //如果请求路径是/getEmployee，就直接再次进行雇员数据的获取，然后将数据封装到集合中
            try {
                getEmployeeList(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("/employee/delete".equals(servletPath)) {
            try {
                deleteEmployee(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if ("/employee/details".equals(servletPath)) {
            try {
                getEmployeedetails(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if ("/search".equals(servletPath)) {
            try {
                searchEmployees(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if ("alter_receiver".equals(servletPath)) {
            try {
                alter_receiver(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if("/modify".equals(servletPath)){
            try {
                modify(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void modify(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String id=request.getParameter("id");
        String title = request.getParameter("title");
        String department = request.getParameter("department");
        DBUtil util=new DBUtil();
        Connection connection=util.getConnection();
        String sql="update employee\n" +
                "set title=?\n" +
                "and dept_id=? \n" +
                "where emp_id=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,title);
        statement.setString(2,department);
        statement.setString(3,id);
    }

    private void alter_receiver(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String idnumber = request.getParameter("idnumber");
        EmployeeDetail details = new EmployeeDetail();
        DBUtil util=new DBUtil();
        Connection connection=util.getConnection();
        String sql="SELECT\n" +
                "\temployee.emp_id, \n" +
                "\temployee.fname, \n" +
                "\temployee.lname\n" +
                "FROM\n" +
                "\temployee\n" +
                "WHERE\n" +
                "\temployee.emp_id = ?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,idnumber);
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()) {
            details.setId(resultSet.getString(1));
            details.setFname(resultSet.getString(2));
            details.setLname(resultSet.getString(3));
        }
        request.setAttribute("placehold_info",details);
        request.getRequestDispatcher("/alter.jsp").forward(request,response);

    }

    private void searchEmployees(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String search_name = request.getParameter("search_name");
        EmployeeDetail details = new EmployeeDetail();
        DBUtil util = new DBUtil();
        Connection connection = util.getConnection();
        String sql = "SELECT\n" +
                "\ta.fname, \n" +
                "\ta.lname, \n" +
                "\ta.start_date, \n" +
                "\ta.title as '职称',\n" +
                "\tbranch.`name` as '分支名称', \n" +
                "\tbranch.address, \n" +
                "\tbranch.city, \n" +
                "\tbranch.state, \n" +
                "\tbranch.zip, \n" +
                "\tb.fname, \n" +
                "\tb.lname,\n" +
                "\tdepartment.`name` as '部门名'\n" +
                "FROM\n" +
                "\temployee AS a\n" +
                "\tINNER JOIN\n" +
                "\tbranch\n" +
                "\tON \n" +
                "\t\ta.assigned_branch_id = branch.branch_id\n" +
                "\tINNER JOIN\n" +
                "\tdepartment\n" +
                "\tON \n" +
                "\t\ta.dept_id = department.dept_id\n" +
                "\tINNER JOIN\n" +
                "\temployee AS b\n" +
                "\tON \n" +
                "\t\tbranch.branch_id = b.assigned_branch_id AND\n" +
                "\t\tdepartment.dept_id = b.dept_id\n" +
                "WHERE\n" +
                "\ta.fname like CONCAT(?,'%')\n" +
                "\tLIMIT 1";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, search_name);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            details.setFname(resultSet.getString(1));
            details.setLname(resultSet.getString(2));
            details.setStart_date(resultSet.getString(3));
            details.setTitle(resultSet.getString(4));
            details.setBranch_name(resultSet.getString(5));
            details.setBranch_address(resultSet.getString(6));
            details.setBranch_city(resultSet.getString(7));
            details.setBranch_state(resultSet.getString(8));
            details.setBranch_zip(resultSet.getString(9));
            details.setSupervisor_fname(resultSet.getString(10));
            details.setSupervisor_lname(resultSet.getString(11));
            details.setDepartment(resultSet.getString(12));
        }
        request.setAttribute("details", details);
        request.getRequestDispatcher("/employeedetail.jsp").forward(request, response);
        util.close(connection, statement, resultSet);
    }

    private void getEmployeedetails(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        String idnumber = request.getParameter("idnumber");
        EmployeeDetail details = new EmployeeDetail();
        //详情信息需要返回的信息
        DBUtil util = new DBUtil();
        Connection connection = util.getConnection();
        String sql = "SELECT\n" +
                "\ta.fname, \n" +
                "\ta.lname, \n" +
                "\ta.start_date, \n" +
                "\ta.title, \n" +
                "\tbranch.`name`, \n" +
                "\tbranch.address, \n" +
                "\tbranch.city, \n" +
                "\tbranch.state, \n" +
                "\tbranch.zip, \n" +
                "\tb.fname, \n" +
                "\tb.lname,\n" +
                "\tdepartment.`name`\n" +
                "FROM\n" +
                "\temployee AS a\n" +
                "\tINNER JOIN\n" +
                "\tbranch\n" +
                "\tON \n" +
                "\t\ta.assigned_branch_id = branch.branch_id\n" +
                "\tINNER JOIN\n" +
                "\tdepartment\n" +
                "\tON \n" +
                "\t\ta.dept_id = department.dept_id\n" +
                "\tINNER JOIN\n" +
                "\temployee AS b\n" +
                "\tON \n" +
                "\t\tbranch.branch_id = b.assigned_branch_id AND\n" +
                "\t\tdepartment.dept_id = b.dept_id\n" +
                "WHERE\n" +
                "\ta.superior_emp_id = b.emp_id and a.emp_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, idnumber);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            details.setFname(resultSet.getString(1));
            details.setLname(resultSet.getString(2));
            details.setStart_date(resultSet.getString(3));
            details.setTitle(resultSet.getString(4));
            details.setBranch_name(resultSet.getString(5));
            details.setBranch_address(resultSet.getString(6));
            details.setBranch_city(resultSet.getString(7));
            details.setBranch_state(resultSet.getString(8));
            details.setBranch_zip(resultSet.getString(9));
            details.setSupervisor_fname(resultSet.getString(10));
            details.setSupervisor_lname(resultSet.getString(11));
            details.setDepartment(resultSet.getString(12));
        }

        try {
            //将具体信息绑定到请求域中
            //请求转发到详情页面
            request.setAttribute("details", details);
            request.getRequestDispatcher("/employeedetail.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        util.close(connection, statement, resultSet);

    }

    //删除功能
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String idnumber = request.getParameter("idnumber");

        DBUtil util = new DBUtil();
        Connection connection = util.getConnection();
        String sql = "delete from employee where emp_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, idnumber);
        boolean success = false;
        int count = statement.executeUpdate();
        if (count == 1) {
            success = true;
        }
        if (success) {

            try {
                //删除成功就直接跳转到初始的雇员信息展示页面
                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath + "/Panel");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void getEmployeeList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Employee> employeeList = new ArrayList<>();  //创建集合用于封装查询到额雇员信息数据

        DBUtil db = new DBUtil();
        Connection connection = db.getConnection();   //获取连接\
        //最好先在navicat中将查询语句写好，然后直接复制到这里
        String sql = "SELECT\n" +
                "\temployee.emp_id ,\n" +
                "\tconcat( employee.fname, ' ', employee.lname ) AS '姓名',\n" +
                "\temployee.start_date '入职时间',\n" +
                "\temployee.title '职位',\n" +
                "\tdepartment.`name` AS '所在部门' \n" +
                "FROM\n" +
                "\temployee\n" +
                "\tINNER JOIN department ON employee.dept_id = department.dept_id\n" +
                "\tORDER BY emp_id";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String employee_id = resultSet.getString(1);
            String employee_name = resultSet.getString(2);        //雇员姓名
            String employee_startdate = resultSet.getString(3);   //入职时间
            String employee_title = resultSet.getString(4);       //雇员职称
            String employee_department = resultSet.getString(5);  //雇员部门
            Employee new_employee = new Employee();
            new_employee.setId(employee_id);
            new_employee.setName(employee_name);
            new_employee.setStart_date(employee_startdate);
            new_employee.setTitle(employee_title);
            new_employee.setDapartment(employee_department);
            employeeList.add(new_employee);                     //将对象添加到集合

        }
        request.setAttribute("employeeList", employeeList);   //将集合添加到请求域
        request.getRequestDispatcher("/Panel.jsp").forward(request, response);
        db.close(connection, statement, resultSet);
    }

    //获取雇员信息列表


}
