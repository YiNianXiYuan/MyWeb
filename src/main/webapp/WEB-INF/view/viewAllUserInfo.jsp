<%--
  Created by IntelliJ IDEA.
  User: arise
  Date: 2021/5/16
  Time: 下午11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>当前所有用户信息</title>
    <link rel="stylesheet" href="/css/viewAllUser.css">
</head>
<body>
<form action="viewAllUser" method="post">
    <table class="gridtable" align="center">
        <caption>用户信息表</caption>
        <thead>
        <tr>
            <th class="center">账&nbsp;&nbsp;&nbsp;&nbsp;号</th>
            <th class="center">密&nbsp;&nbsp;&nbsp;&nbsp;码</th>
            <th class="center">用&nbsp;户&nbsp;名</th>
            <th class="center">注销账号</th>
        </tr>
        </thead>
        <tbody>
        <!-- 开始循环 -->
        <c:forEach items="${usersSession}" var="userS">
            <tr>
                <td class='center'>${userS.account}</td>
                <td class='center'>${userS.passWord}</td>
                <td class='center'>${userS.username}</td>
                <td class='center'>
                    <a href="/deleteUser?accounts=${userS.account}">注销</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>

