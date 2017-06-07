<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>TodoList待办事项管理系统</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/css/login.css"/>" media="all">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
</head>
<body>

<div class="login-form">
    <h1>登录</h1>
    <div class="login-top">
        <form action="login" method="post">
            <div class="login-ic">
                <i></i>
                <input type="text" name="username" placeholder="用户名" required/>
                <div class="clear"></div>
            </div>
            <div class="login-ic">
                <i class="icon"></i>
                <input type="password" name="password" placeholder="密码" required/>
                <div class="clear"></div>
            </div>
            <div class="log-bwn">
                <input type="submit" value="登录">
            </div>
        </form>
    </div>
    <p class="copy">&copy;&nbsp;2017&nbsp;南京信息工程大学滨江学院</p>
</div>

<script src="<c:url value="/lib/jquery-3.2.1.min.js"/>"></script>
</body>
</html>