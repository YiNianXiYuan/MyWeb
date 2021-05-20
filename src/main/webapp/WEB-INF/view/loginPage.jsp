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
    <title>登录界面</title>
    <link rel="stylesheet" href="/css/login.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
<form action="login" method="post">
    <div id="login-box">
        <h1>Login</h1>
        <div class="form">
            <div class="item">
                <i class="fa fa-github-alt" style="font-size:24px"></i>
                <input type="text" name="account" placeholder="Username">
            </div>
            <div class="item">
                <i class="fa fa-search" style="font-size:24px"></i>
                <input type="password" name="password" placeholder="Password">
            </div>
        </div>
        <button type="submit" name="submit">Login</button>
        <button type="button" name="register" onclick="window.location.href = '/registerButton'">Register</button>
    </div>
</form>
</body>
</html>
