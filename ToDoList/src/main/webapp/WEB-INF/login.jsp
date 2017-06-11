<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>ToDoList待办事项管理系统</title>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<c:url value="/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>"/>
  <link rel="stylesheet" href="<c:url value="/css/styles.css"/>"/>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container page-content">
  <div class="row">
    <div class="col-md-6 col-md-offset-3">
      <div class="content-box-header">
        <div class="panel-title">
          登录
        </div>
        <div class="panel-options">
          <a href="register">注册</a>
        </div>
      </div>
      <div class="content-box-large box-with-header">
        <sf:form commandName="userDTO" method="post" cssClass="form" role="form">
          <div class="form-group">
            <sf:input path="username" cssClass="form-control" placeholder="username"/>
          </div>
          <div class="form-group">
            <sf:password path="password" cssClass="form-control" placeholder="password"/>
          </div>
          <div class="form-group">
            <input type="submit" value="登录" class="form-control btn btn-primary">
          </div>
        </sf:form>
      </div>
    </div>
  </div>
</div>

<script src="<c:url value="/lib/jquery-3.2.1.min.js"/>"></script>
<script src="<c:url value="/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>"></script>
</body>
</html>
