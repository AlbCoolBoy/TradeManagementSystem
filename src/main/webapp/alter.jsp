<%--
  Created by IntelliJ IDEA.
  User: ALB
  Date: 2022-05-15
  Time: 9:50
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
        <nav>ss's's
            <ul class="nav nav-justified">

                <li class="active">
                    <a href="${pageContext.request.contextPath}/Panel.jsp">雇员管理</a>
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
    <form action="/modify" method="post" class="form-horizontal">
        <div class="form-group">
            <label for="id" class="col-sm-2 control-label">内部编号：</label>
            <div class="col-sm-10">
                <input type="text" id="id" name="id" value="${details.id}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="firstname" class="col-sm-2 control-label">名:</label>
            <div class="col-sm-10">
                <input type="text" class="" id="firstname" name="firstname" value=${details.fname} readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-2 control-label">姓：</label>
            <div class="col-sm-10">
                <input type="text" class="" id="lastname" name="lastname" value=${details.lname} readonly>
            </div>
        </div>
        <%--雇员的职称，可以进行修改,但是使用下拉列表的方式实现--%>
        <div class="form-group">
            <label for="title" class="col-sm-2 control-label">职位：</label>
            <div class="col-sm-10">
                <select name="title" id="title">
                    <option value="Vice President">Vice President</option>
                    <option value="Treasurer">Treasurer</option>
                    <option value="Operations Manager">Operations Manager</option>
                    <option value="Loan Manager">Loan Manager</option>
                    <option value="Head Teller">Head Teller</option>
                    <option value="Teller">Teller</option>
                </select>
            </div>
        </div>
        <%--修改雇员的所在部门--%>
        <div class="form-group">
            <label for="department" class="col-sm-2 control-label">部门：</label>
            <div class="col-sm-10">
                <select name="department" id="department" >
                    <option value="1">Operations</option>
                    <option value="2">Loans</option>
                    <option value="3">Adminstration</option>
                </select>
            </div>
        </div>
    </form>
    <br>
    <br>
    <ol class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/getEmployee">首页</a></li>
        <li class="active"><a href="#">雇员信息修改</a></li>
    </ol>
</div>

</body>
</html>
