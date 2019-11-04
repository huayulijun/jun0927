<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>修改部门</title>
</head>
<body align="center">
<h3>修改部门</h3>
<form action="<%=request.getContextPath()%>/updatedept.do" method="post">
    <input type="hidden" name="did" value="${dept.did}" ><br>
    部门:<input type="text" name="deptbh" value="${dept.deptbh}"/><br>
    <a href="<%=request.getContextPath()%>/deptselect.do">返回</a>
    <input type="submit" value="提交"/>
</form>
</body></html>
