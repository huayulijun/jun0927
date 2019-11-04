<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
</head>
<body align="center">
<h4>请填写你要注册的账户和密码</h4>
<form action="<%=request.getContextPath()%>/addlogin.do" method="post">
    输入账户:<input type="text" name="username" placeholder="输入账户名"><br>
    输入密码:<input type="password" name="password" placeholder="输入密码"><br>
    <input type="submit" value="提交">
</form>
<a href="login.jsp">返回登录</a>
</body>
</html>