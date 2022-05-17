<%--
  Created by IntelliJ IDEA.
  User: ALB
  Date: 2022-04-21
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%--panel是管理员登录后出现的初始页面
    但是在该初始页面中也会将雇员信息列表展示出来
    在列表总提供对雇员信息进行删除和修改的按钮
    侧边栏会设置关于部门和其他信息的按钮
    页面底部设置添加雇员的按钮，进行雇员信息的添加
    --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Panel</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <link rel="icon" href="https://fastly.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.35/favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/justified-nav/">
    <script src="https://fastly.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.35/assets/js/ie-emulation-modes-warning.js"></script>
    <style>
        #before {
            box-sizing: border-box;
        }

        .container {
            padding-right: 0px;
            padding-left: 0px;
            margin-right: auto;
            margin-left: auto;
        }

        .nav {
            padding-left: 0;
            margin-bottom: 0;
            list-style: none;
        }

        .nav-justified {
            background-color: #eee;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 100%;
            max-height: 52px;
        }

        .nav-justified li a {
            padding-top: 15px;
            padding-bottom: 15px;
            margin-bottom: 0;
            font-weight: 700;
            color: #777;
            text-align: center;
        ] background-color: #e5e5e5;
            backround-repeat: repeat-x;
            border-bottom: 1px solid #d5d5d5;
            border-right: 1px solid #d5d5d5;
            border-left: 1px solid #d5d5d5;
        }

        ol, ul {
            margin-top: 0;
        }

        ul {
            display: block;
            margin-block-start: 1em;
            margin-block-end: 1em;
            margin-inline-start: 0px;
            margin-inline-end: 0px;
            padding-inline-start: 40px;
        }
    </style>

</head>
<body>
<script
        type="text/javascript"
        src="${pageContext.request.contextPath}/Resources/js/jquery-3.2.1.min.js"
<%--一定要记得使用这种方式进行Bootstrap中文件的获取啊，只有这种方式不会出错了,但是应该有其他的原因，暂时不深究了，吐了啊
     切记！！！！！！--%>
></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script type="text/javascript"
        src="${pageContext.request.contextPath}/Resources/js/bootstrap.min.js"
></script>

<div class="container">
    <div class="masthead">
        <h3 class="text-muted" id="before">OA_system</h3>
        <nav>
            <ul class="nav nav-justified">

                <li class="active">
                    <a href="${pageContext.request.contextPath}/getEmployee">雇员管理</a>
                </li>
                <li>
                    <a href="">交易管理</a>
                </li>
                <li>
                    <a href="${pagecontext.request.contextPath}/Product">产品管理</a>
                </li>
                <li>
                    <a href="">客户管理</a>
                </li>
                <Li>
                    <a href="">订单汇总</a>
                </Li>
                <li>
                    <a href="">个人信息</a>
                </li>
            </ul>
        </nav>
    </div>
    <br>
    <br>
    <%--写一个搜索--%>
    <form action="${pageContext.request.contextPath}/search" class="form-inline" method="post">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="输入姓名" name="search_name">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
    <hr>
    <%--下面是展示雇员信息的表格--%>
    <table class="table table-striped table-hover">
        <tr>
            <th>雇员姓名</th>
            <th>入职时间</th>
            <th>雇员职称</th>
            <th>雇员部门</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${employeeList}" var="employee">
            <tr>
                <td>${employee.name}</td>
                <td>${employee.start_date}</td>
                <td>${employee.title}</td>
                <td>${employee.dapartment}</td>
                <td>
                    <input type="button" value="删除"
                           class="btn btn-danger"
                           onclick="javascript:window.location.href='${pageContext.request.contextPath}/employee/delete?idnumber=${employee.id}'">
                    <input type="button" value="详情"
                           class="btn btn-success"
                           onclick="javascript:window.location.href='${pageContext.request.contextPath}/employee/details?idnumber=${employee.id}'">
                    <input type="button" value="修改"
                           class="btn btn-info"
                           onclick="javascript:window.location.href='${pageContext.request.contextPath}/employee/alter?idnumber=${employee.id}'">
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
