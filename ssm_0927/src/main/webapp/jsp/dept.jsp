<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>查询部门</title>

    <script type="text/javascript">
        function show(tr_id) {
            var tr_show = document.getElementById(tr_id);
            if(tr_show.style.display==='none'){
                tr_show.style.display='block';
            }else {
                tr_show.style.display='none';
            }
        }
    </script>
</head>
<body>
<h3 align="center">部门信息</h3>
<table border="2" align="center" bordercolor="">
    <tr align="center">
        <td>编号</td>
        <td>部门</td>

        <td><a href="<%=request.getContextPath()%>/jsp/deptinsert.jsp"><font color="red">添加部门</font></a></td>
    </tr>
        <c:forEach items="${listdept}" var="dept" varStatus="stat">
            <tr>
                <td>${stat.index+1}</td>
                <td onclick="show(${stat.index+1})">${dept.deptbh }</td>
                <td><a href="deletedepe.do?did=${dept.did}">删除</a>|<a href="deptbyid.do?did=${dept.did}">修改</a></td>
            </tr>
            <tr id = "${stat.index+1}" style="display: none">
                <c:forEach items="${dept.listemp}" var="emp1">
                    <td>${emp1.name}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    <tr><td>--->></td><td>--->></td><td><a href="<%=request.getContextPath()%>/list.do"><center>返回员工</center></a></td></tr>
</table>
</body>
</html>