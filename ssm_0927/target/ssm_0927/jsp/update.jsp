<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改员工</title>
</head>
<body align="center">
<h3>修改员工</h3>
<form action="<%=request.getContextPath()%>/update.do" method="post">
     <input type="hidden" name="eid" value="${emp.eid}" ><br>
姓名:<input type="text" name="name"  value="${emp.name}"  ><br>
年龄:<input type="text" name="age"  value="${emp.age}"  ><br>
性别:男.<input type="radio"  name="sex" value="男" ${emp.sex=='男'?'checked':''} >
女.<input type="radio" name="sex" value="女" ${emp.sex=='女'?'checked':''}><br>
邮箱:<input type="text" name="mail" value="${emp.mail}" placeholder="登录名@主机名.域名"><br>
爱好:<input type="text" name="ah"  value="${emp.ah}"  ><br>
部门:<select name="did">
    <c:forEach items="${deptlist}" var="deptlist">
        <option value="${deptlist.did}" ${emp.did==deptlist.did?'selected':''}>${deptlist.deptbh}</option>
    </c:forEach>
</select><br>
    修改角色:<c:forEach items="${roleList}" var="role">
    <c:forEach var="listrole" items="${emp.listrole}">
        <c:if test="${listrole.roleid==role.roleid}">
            <c:set var="id" value="true"></c:set>
        </c:if>
    </c:forEach>
    <c:choose>
        <c:when test="${id}">
            ${role.rolename}<input type="checkbox" value="${role.roleid}"} name="roleid" checked>
        </c:when>
        <c:otherwise>
            ${role.rolename}<input type="checkbox" value="${role.roleid}"} name="roleid">
        </c:otherwise>
    </c:choose>
    <c:set value="false" var="id"></c:set>
</c:forEach><br>
    <a href="<%=request.getContextPath()%>/list.do">返回</a>
<input type="submit" value="确定修改">
</form>
</body>
</html>