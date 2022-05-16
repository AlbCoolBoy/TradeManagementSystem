<%--
  Created by IntelliJ IDEA.
  User: ALB
  Date: 2022-04-21
  Time: 11:24
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

    <style>
        .login {
            width: 600px;
            height: 400px;
            margin-left: auto;;
            margin-right: auto;
            margin-top: 150px;
            /*暂时就把margintop设置这么多吧，后面还要在顶部添加title*/
        }
    </style>

</head>
<body>
<script
        type="text/javascript"
        src="${pageContext.request.contextPath}/Resources/js/jquery-3.2.1.min.js"
<%--一定要记得使用这种方式进行Bootstrap中文件的获取啊，只有这种方式不会出错了,但是应该有其他的原因，暂时不深究了，吐了啊
     切记！！！！！！--%>
        integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
        crossorigin="anonymous"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script type="text/javascript"
        src="${pageContext.request.contextPath}/Resources/js/bootstrap.min.js"
        integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
        crossorigin="anonymous"></script>
<%--登录页面信息提交表单--%>
<%--前端向后端发送请求，记得一定要加项目名--%>
<form class="login" action="${pageContext.request.contextPath}/Login" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">Username</label>
        <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Acount" name="username">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" name="checkobx" value="yes"> 十天内免登录
        </label>
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
</form>
</body>
</html>
