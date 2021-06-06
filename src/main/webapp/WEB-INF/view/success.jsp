<%--
  Created by IntelliJ IDEA.
  User: arise
  Date: 2021/5/17
  Time: 下午6:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功界面</title>
    <link href="/css/success.css" rel="stylesheet" type="text/css">
</head>
<body>
<%--<form action="/success" method="post">--%>

<div id="top">
    <div id="user">
        欢迎您！${user.username}
<%--        ${user.account}--%>
<%--        获取输入的账号--%>
<%--        <%=request.getParameter("account")%>--%>
    </div>

    <div>
        <%--            <jsp:useBean id="time" class="java.util.Date"/>--%>
        <%--            现在时间：<%=time%>--%>
<%--            <input type="text" id="time">--%>
            <p class="time" id="time">time</p>
    </div>

    <div id="top_img">
        <main id="top_main">
            <div class="slogn">呐，你在找什么呢</div>
            <div class="siteurl"><h1>NAVIGATION.COM</h1></div>
            <ul id="top_navlist">
                <a class="top_nav" href="https://acgbus.com/" target="_blank">
                    <li>二次元导航</li>
                </a>
                <a class="top_nav" href="https://www.bilibili.com/" target="_blank">
                    <li>哔哩哔哩</li>
                </a>
                <a class="top_nav" href="http://www.acgjc.com/" target="_blank">
                    <li>漫音社</li>
                </a>
                <a class="top_nav" href="https://www.8kana.com/" target="_blank">
                    <li>不可能de世界</li>
                </a>
            </ul>
        </main>
        <footer id="top_footer">
            <span id="top_copyright">
            <hr class="top_hr_style02">
            <p class="foot_txt">Navigation是一个泛导航交流社区,在这里你能找到很多有趣的东西。</p>
            <hr class="top_hr_style02">
            Copyright &copy; 2021 <a href="#">NAVIGATION.com</a> All Rights Reserved.
</span>
        </footer>
    </div>
</div>
<div style="display:none;"/>
<%--</form>--%>
<%--    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"/>--%>
<script src="/js/clock.js"></script>
</body>
</html>
