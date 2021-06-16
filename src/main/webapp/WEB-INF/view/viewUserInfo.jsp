<%--
  Created by IntelliJ IDEA.
  User: arise
  Date: 2021/5/16
  Time: 下午11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>当前用户信息</title>

</head>
<body>
    当前用户账号：${getAccount}
    <br>
    当前用户密码：${getPassWord}
    <br>
    当前用户用户名：${getUsername}
    <br>
    <a href="/userModify">修改信息</a>
</body>
</html>

