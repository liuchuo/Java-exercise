<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <title>ToDoList待办事项管理系统</title>
  <meta charset="UTF-8"/>
  <link rel="stylesheet" href="<c:url value="/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>">
  <link rel="stylesheet" href="<c:url value="/css/styles.css"/>"/>
  <link rel="stylesheet" href="<c:url value="/css/forms.css"/>">
</head>
<body>
<div class="header">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="logo">
          <h1><a href="home">ToDoList待办事项管理系统</a>
            <a href="#" class="pull-right"><img src="<c:url value='${profile.avatar}'/> ">&nbsp;${profile.nickname}</a>
          </h1>

        </div>
      </div>
    </div>
  </div>
</div>
<div class="page-content container">
  <div class="row">
    <div class="col-md-10 col-md-offset-1">
      <div class="content-box-header">
        <div class="panel-title">
          添加待办事项
        </div>
      </div>
      <div class="content-box-large box-with-header">
        <form method="get" action="add_content" class="form-inline" role="form">
          <div class="form-group col-sm-11 col-xs-11">
            <input type="text" name="content" title="content" class="form-control" placeholder="添加任务...">
          </div>
          <div class="form-group">
            <input type="submit" class="btn btn-primary form-control">
          </div>
        </form>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-10 col-md-offset-1">
      <div class="content-box-large">
        <div class="panel-heading">
          <div class="panel-title">
            待办事项
          </div>
        </div>
        <div class="panel-body">
          <table class="table table-hover">
            <thead>
            <tr>
              <th>选中已完成</th>
              <th>具体内容</th>
              <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${toDoTask}">
              <tr>
                <td><input type="checkbox" name="task_id" value="${item.id}" title="state" onchange="submit(this);">
                </td>
                <td><span onclick="edit(this, '${item.id}')">${item.content}</span></td>
                <td><img src="<c:url value="/img/delete.png"/>" width="16px" height="16px"
                         onclick="drop('task_id=${item.id}')">
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-10 col-md-offset-1">
      <div class="content-box-large">
        <div class="panel-heading">
          <div class="panel-title">
            已完成
          </div>
        </div>
        <div class="panel-body">
          <table class="table table-hover">
            <thead>
            <tr>
              <th>撤销已完成</th>
              <th>具体内容</th>
              <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${completedTask}">
              <tr>
                <td><input type="checkbox" name="task_id" value="${item.id}" title="state" checked
                           onchange="submit(this)"></td>
                <td><span onclick="edit(this, '${item.id}')">${item.content}</span></td>
                <td><img src="<c:url value="/img/delete.png"/>" width="16px" height="16px"
                         onclick="drop('task_id=${item.id}')">
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="<c:url value="/lib/jquery-3.2.1.min.js"/>"></script>
<script type="text/javascript">
    function submit(checkbox) {
        if (checkbox.checked) {
            location.href = "completed_task?" + checkbox.getAttribute("name") + "=" + checkbox.getAttribute("value");
        } else {
            location.href = "to_do_task?" + checkbox.getAttribute("name") + "=" + checkbox.getAttribute("value");
        }
    }

    function drop(url) {
        location.href = "drop_task?" + url;
    }

    function edit(span, taskId) {
        span.innerHTML = "<input id='edit' type='text' value='" + span.innerText + "' class='col-md-12' />";
        var $input = $("#edit");
        $input.focus();
        var text = $input.val();
        $input.val("").focus().val(text);
        $input.blur(function () {
            location.href = "update_task?content=" + $input.val() + "&task_id=" + taskId;
        });
    }
</script>
</body>
</html>
