<%--
  Created by IntelliJ IDEA.
  User: arise
  Date: 2021/5/19
  Time: 下午11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
<%--    <link href="${pageContext.request.contextPath}/css/clock.css" rel="stylesheet">--%>
</head>
<body>
<div style="width: 100%; azimuth: center; text-align: center;">
    <input type="text" id="time">
</div>
<div style="width: 100%; text-align: center; margin-top: 20px;">
    <input type="button" οnclick="" value="定时">
</div>
<script>
    function timeCount() {
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth();
        var day = date.getDate();
        var hour = date.getHours();
        var minute = date.getMinutes();
        var second = date.getSeconds();
        if (hour < 10) {
            hour = "0" + hour;
        }
        if (minute < 10) {
            minute = "0" + minute;
        }
        if (second < 10) {
            second = "0" + second;
        }
        var time = hour + ":" + minute + ":" + second;
        document.getElementById("time").value = time;
    }

    window.setInterval(timeCount, 1000);
</script>
</body>
</html>