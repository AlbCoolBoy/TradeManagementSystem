<%--
  Created by IntelliJ IDEA.
  User: ALB
  Date: 2022-05-13
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                    <a href="">产品管理</a>
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
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/getEmployee">首页</a></li>
            <li class="active"><a href="#">雇员详细信息</a></li>
        </ol>
        <div class="divider"></div>
        <table class="table table-striped table-hover">
            <tr>
                <th>Parameter</th>
                <th>Value</th>
            </tr>
            <tr>
                <td>姓名：</td>
                <td>${details.fname} ${details.lname}</td>
            </tr>
            <tr>
                <td>职位：</td>
                <td>${details.title}</td>
            </tr>
            <tr>
                <td>所在部门：</td>
                <td>${details.department}</td>
            </tr>
            <tr>
                <td>入职时间：</td>
                <td>${details.start_date}</td>
            </tr>
            <tr>
                <td>所属分区：</td>
                <td>${details.branch_name}</td>
            </tr>
            <tr>
                <td>分区地址：</td>
                <td>${details.branch_address}</td>
            </tr>
            <tr>
                <td>所在城市：</td>
                <td>${details.branch_city}</td>
            </tr>
            <tr>
                <td>所在州：</td>
                <td>${details.branch_state}</td>
            </tr>
            <tr>
                <td>邮编：</td>
                <td>${details.branch_zip}</td>
            </tr>
            <tr>
                <td>上级领导：</td>
                <td>${details.supervisor_fname} ${details.supervisor_lname}</td>
            </tr>
        </table>

    </div>
</div>


</body>
</html>
