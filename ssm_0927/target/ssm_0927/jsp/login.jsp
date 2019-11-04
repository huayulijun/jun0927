<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
           pageEncoding="UTF-8" isErrorPage="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>登录页面</title>
     </head>


 <body align="center">
 <h3>请先登录</h3>
<form action="<%=request.getContextPath()%>/login.do" method="post">
    账户:<input type="text" name="username" placeholder="输入账户名"><br>
    密码:<input type="password" name="password" placeholder="输入密码"><br>
    <input type="submit" value="Login">
</form>
</body>
 </html>
