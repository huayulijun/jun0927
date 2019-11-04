<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加页面</title>

</head>
<body align="center">
<h3>添加员工</h3>
<c:forEach var="errs" items="${err}">
    ${errs.defaultMessage}<br>
</c:forEach>
<form action="<%=request.getContextPath()%>/insert.do" method="post">
员工名称:<input type="text" name="name" id="name"><br>
年龄:<input type="text" name="age" ><br>
性别:男.<input type="radio" value="男" name="sex">
女.<input type="radio" value="女"  name="sex"><br>
邮箱:<input type="text" name="mail" placeholder="登录名@主机名.域名"  ><br>
爱好:<input type="text" name="ah" ><br>
    部门:<select name="did">
    <option value="0">请选择</option>
    <c:forEach items="${deptlist}" var="dept">
        <option value="${dept.did}">${dept.deptbh}</option>
    </c:forEach>
</select><br>
    角色:<c:forEach items="${roleList}" var="role">
    ${role.rolename}<input type="checkbox" value="${role.roleid}" name="roleid">
</c:forEach><br>
    <a href="<%=request.getContextPath()%>/list.do">返回</a>
<input type="submit" value="确认添加">
</form>
</body>
</html>