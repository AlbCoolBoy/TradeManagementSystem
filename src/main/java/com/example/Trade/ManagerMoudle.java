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
        ("/search"), ("/employee/modify")})
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
        } else if ("/employee/alter".equals(servletPath)) {
            try {
                send_placeholder(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if ("/employee/modify".equals(servletPath)) {
            try {
                modify(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void modify(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String id = request.getParameter("id");
        String department=request.getParameter("department");
        String branch = request.getParameter("branch");
        String title = request.getParameter("title");
        int departmentId = Integer.parseInt(department);
        int branchId = Integer.parseInt(branch);
        DBUtil db = new DBUtil();
        Connection connection=db.getConnection();
        String sql="update employee\n" +
                "set dept_id=?,assigned_branch_id=?,title=? \n" +
                "where emp_id=?\n" +
                "\n";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,departmentId);
        statement.setInt(2,branchId);
        statement.setString(3,title);
        statement.setString(4,id);
        int count = statement.executeUpdate();
        boolean success=false;
        if(count==1){
            success=true;
        }
        if(success){
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/getEmployee");
        }

    }

    private void send_placeholder(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String idnumber = request.getParameter("idnumber");
        EmployeeDetail details = new EmployeeDetail();
        DBUtil util = new DBUtil();
        Connection connection = util.getConnection();
        String sql = "select fname,lname from \n" +
                "employee where emp_id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, idnumber);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            details.setFname(resultSet.getString(1));
            details.setLname(resultSet.getString(2));
        }
        details.setId(idnumber);
        util.close(connection, statement, resultSet);
        request.setAttribute("details", details);
        request.getRequestDispatcher("/alter.jsp").forward(request, response);
    }


    private void searchEmployees(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String search_name = request.getParameter("search_name");
        EmployeeDetail details1 = new EmployeeDetail();
        EmployeeDetail details2 = new EmployeeDetail();
        DBUtil util1 = new DBUtil();
        Connection connection1 = util1.getConnection();
        String sql1 = "SELECT\n" +
                "\ta.fname, \n" +
                "\ta.lname, \n" +
                "\tb.fname, \n" +
                "\tb.lname\n" +
                "FROM\n" +
                "\temployee AS a,\n" +
                "\temployee AS b\n" +
                "WHERE\n" +
                "\ta.superior_emp_id = b.emp_id\n" +
                "\tand a.fname like CONCAT(?,'%')\n" +
                "\tLIMIT 1";
        PreparedStatement statement1 = connection1.prepareStatement(sql1);
        statement1.setString(1, search_name);
        ResultSet resultSet1 = statement1.executeQuery();
        while (resultSet1.next()) {
            details1.setFname(resultSet1.getString(1));
            details1.setLname(resultSet1.getString(2));
            details1.setSupervisor_fname(resultSet1.getString(3));
            details1.setSupervisor_lname(resultSet1.getString(4));
        }
        util1.close(connection1, statement1, resultSet1);
        DBUtil util2 = new DBUtil();
        Connection connection2 = util2.getConnection();
        String sql2 = "SELECT\n" +
                "\temployee.start_date, \n" +
                "\tdepartment.`name` as '部门名称', \n" +
                "\tbranch.`name` as '分支名称', \n" +
                "\tbranch.address, \n" +
                "\tbranch.city, \n" +
                "\tbranch.state, \n" +
                "\tbranch.zip, \n" +
                "\temployee.title\n" +
                "FROM\n" +
                "\temployee\n" +
                "\tINNER JOIN\n" +
                "\tdepartment\n" +
                "\tON \n" +
                "\t\temployee.dept_id = department.dept_id\n" +
                "\tINNER JOIN\n" +
                "\tbranch\n" +
                "\tON \n" +
                "\t\temployee.assigned_branch_id = branch.branch_id\n" +
                "\t\tand employee.fname like CONCAT(?,'%')";
        PreparedStatement statement2 = connection2.prepareStatement(sql2);
        statement2.setString(1, search_name);
        ResultSet resultSet2 = statement2.executeQuery();
        while (resultSet2.next()) {
            details2.setStart_date(resultSet2.getString(1));
            details2.setDepartment(resultSet2.getString(2));
            details2.setBranch_name(resultSet2.getString(3));
            details2.setBranch_address(resultSet2.getString(4));
            details2.setBranch_city(resultSet2.getString(5));
            details2.setBranch_state(resultSet2.getString(6));
            details2.setBranch_zip(resultSet2.getString(7));
            details2.setTitle(resultSet2.getString(8));
        }
        util2.close(connection2, statement2, resultSet2);
        request.setAttribute("details", details1);
        request.setAttribute("details2", details2);
        request.getRequestDispatcher("/employeedetail.jsp").forward(request, response);

    }

    //获取详细信息的时候，仅仅通过一次的多表联查会出问题的，需要使用多个查询
    //将19个雇员的详细信息全部查询出来
    private void getEmployeedetails(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        String idnumber = request.getParameter("idnumber");
        //该对象用于封装雇员姓名和上级领导的姓名
        EmployeeDetail details = new EmployeeDetail();
        EmployeeDetail details2 = new EmployeeDetail();
        //详情信息需要返回的信息
        DBUtil util = new DBUtil();
        Connection connection = util.getConnection();
        String sql1 = "SELECT\n" +
                "\ta.fname, \n" +
                "\ta.lname, \n" +
                "\t\n" +
                "\tb.fname, \n" +
                "\tb.lname\n" +
                "FROM\n" +
                "\temployee AS a,\n" +
                "\temployee AS b\n" +
                "WHERE\n" +
                "\ta.superior_emp_id = b.emp_id and a.emp_id=?";
        PreparedStatement statement = connection.prepareStatement(sql1);
        statement.setString(1, idnumber);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String Fname = resultSet.getString(1);
            details.setFname(resultSet.getString(1));
            details.setLname(resultSet.getString(2));
            details.setSupervisor_fname(resultSet.getString(3));
            details.setSupervisor_lname(resultSet.getString(4));
        }
        util.close(connection, statement, resultSet);
        //该语句用于查询雇员入职时间，部门名称、所在分支的信息、职称
        String sql2 = "SELECT\n" +
                "\temployee.start_date, \n" +
                "\tdepartment.`name`, \n" +
                "\tbranch.`name`, \n" +
                "\tbranch.address, \n" +
                "\tbranch.city, \n" +
                "\tbranch.state, \n" +
                "\tbranch.zip, \n" +
                "\temployee.title\n" +
                "FROM\n" +
                "\temployee\n" +
                "\tINNER JOIN\n" +
                "\tdepartment\n" +
                "\tON \n" +
                "\t\temployee.dept_id = department.dept_id\n" +
                "\tINNER JOIN\n" +
                "\tbranch\n" +
                "\tON \n" +
                "\t\temployee.assigned_branch_id = branch.branch_id\n" +
                "\t\tand employee.emp_id=?";
        DBUtil util2 = new DBUtil();
        Connection connection2 = util2.getConnection();
        PreparedStatement statement1 = connection2.prepareStatement(sql2);
        statement1.setString(1, idnumber);
        ResultSet resultSet1 = statement1.executeQuery();
        while (resultSet1.next()) {
            details2.setStart_date(resultSet1.getString(1));
            details2.setDepartment(resultSet1.getString(2));
            details2.setBranch_name(resultSet1.getString(3));
            details2.setBranch_address(resultSet1.getString(4));
            details2.setBranch_city(resultSet1.getString(5));
            details2.setBranch_state(resultSet1.getString(6));
            details2.setBranch_zip(resultSet1.getString(7));
            details2.setTitle(resultSet1.getString(8));
        }
        util2.close(connection2, statement1, resultSet1);
        //将两个对象都转发页面中，这样就能解决查不出全部数据的bug
        request.setAttribute("details", details);
        request.setAttribute("details2", details2);
        request.getRequestDispatcher("/employeedetail.jsp").forward(request, response);

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
