<%--
  Created by IntelliJ IDEA.
  User: ALB
  Date: 2022-04-21
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Login</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

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
<%--做一个页头，显示用用户头像和信息--%>
<%--展示用户头和邮箱等信息--%>
<%--并在页头下方显示路径导航，路径导航设置链接--%>
<div>
    <%--用户头像--%>
    <img src="" alt="">

</div>
<%--设置侧边导航栏--%>


</body>
</html>
