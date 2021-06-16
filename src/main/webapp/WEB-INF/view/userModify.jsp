<%--
  Created by IntelliJ IDEA.
  User: arise
  Date: 2021/6/16
  Time: 下午1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户修改</title>
</head>
<body>
<form action="/userModify" method="post">
    新的密码：<input type="text" name="passWord" placeholder="请输入新的密码">
    新的用户名:<input type="text" name="username" placeholder="请输入新的名字">
    <button type="submit" name="sumbit" id="sumbit">确认修改</button>
    <button type="button" name="success" onclick="window.location.href = '/success'">返回</button>
    <button type="reset" name="reset">重置信息</button>
</form>
</body>
</html>
