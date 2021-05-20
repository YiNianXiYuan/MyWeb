<%--
  Created by IntelliJ IDEA.
  User: arise
  Date: 2021/5/16
  Time: 下午11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册界面</title>
    <link rel="stylesheet" href="/css/register.css">
</head>
<body>
<div class="rg_layout">
    <div class="rg_left">
        <p>新用户注册</p>
        <p>USER REGISTER</p>
    </div>
    <div class="rg_center">
        <div class="rg_form">
            <form action="register" method="post">
                <table>
                    <tr>
                        <td class="td_left"><label for="account">用户名</label></td>
                        <td class="td_right"><input type="text" name="account" id="account" placeholder="请输入用户名"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right"><input type="password" name="password" id="password" placeholder="请输入密码"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="resure">确认密码</label></td>
                        <td class="td_right"><input type="password" name="resure" id="resure" placeholder="请确认您的密码"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="email">Email</label></td>
                        <td class="td_right"><input type="email" name="email" id="email" placeholder="请输入邮箱"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="name">姓名</label></td>
                        <td class="td_right"><input type="text" name="name" id="name" placeholder="请输入姓名"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="tel">手机号</label></td>
                        <td class="td_right"><input type="text" name="tel" id="tel" placeholder="请输入手机号"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label>性别</label></td>
                        <td class="td_right"><input type="radio" name="gender" value="male">男
                            <input type="radio" name="gender" value="female">女</td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="birthday">出生日期</label></td>
                        <td class="td_right"><input type="date" name="birthday" id="birthday"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="checkcode">验证码</label></td>
                        <td class="td_right"><input type="text" name="checkcode" id="checkcode" placeholder="请输入验证码">
                            <img id="img_check" src="/image/VerificationCode.jpg" >
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" id="btn_sub" value="注册"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="rg_right">
        <p>已有账号?<a href="/loginButton">立即登录</a></p>
    </div>
</div>
</body>
</html>



<%--<div>--%>
<%--    <form action="register" method="post">--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td><label for="account">用户名：</label></td>--%>
<%--                <td><input type="text" id="account" name="account" value=""></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td><label for="password">密码：</label></td>--%>
<%--                <td><input type="password" id="password" name="password" value=""></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td><label for="resure">确认密码：</label></td>--%>
<%--                <td><input type="password" id="resure" name="resure" value=""></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td colspan="2"><input type="submit" name="submit" value="注册"></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form>--%>
<%--</div>--%>