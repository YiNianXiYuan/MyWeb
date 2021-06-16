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
    <title>分页查询</title>
    <link rel="stylesheet" href="/css/viewAllUser.css">
</head>
<body>
<form action="/page" method="post">
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
<%--        <c:forEach items="${pageBean.list}" var="users">--%>
        <c:forEach items="${pageBeanList}" var="users">
            <tr>
                <td class='center'>${users.account}</td>
                <td class='center'>${users.passWord}</td>
                <td class='center'>${users.username}</td>
                <td class='center'><a href="/deleteUserPage?account=${users.account}">注销</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!--分页-->
    <nav class="navbar-right">
        <ul class="pagination" id="paging">
            <li>
                <span>当前第${pageBean.localPage }页</span>
            </li>
            <li>
                <a href="/page?localPage=1">
                    <span aria-hidden="true">首页</span>
                </a>
            </li>
            <li>
                <a href="/page?localPage=${pageBean.prePage }" aria-label="上一页">
                    <span aria-hidden="true">上一页</span>
                </a>
            </li>
            <li>

            </li>
            <li>
                <a href="/page?localPage=${pageBean.nextPage }" aria-label="下一页">
                    <span aria-hidden="true">下一页</span>
                </a>
            </li>
            <li>
                <a href="/page?localPage=${pageBean.lastPage }" aria-label="尾页">
                    <span aria-hidden="true">尾页</span>
                </a>
            </li>
            <li>
                <span>总页数：共${pageBean.totalPage }页</span>
                <span>总记录数：共${pageBeanTotalNum }条</span>
            </li>
        </ul>
    </nav>
</form>
</body>
</html>

