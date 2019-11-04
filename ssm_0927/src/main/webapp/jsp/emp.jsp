<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询员工主页</title>
    <script type="text/javascript">
       function aa(e) {
           var url=e.href;
           event.preventDefault();
           var myform=document.getElementById("form1");
           myform.action=url;
           myform.submit();
       }
    </script>
</head>
<body>
<h4 align="center"><font color="fuchsia">员工信息</font></h4>
	当前用户是:${s.username}<br>
<a href="<%=request.getContextPath()%>/logout.do"><font color="red">注销</font></a>
<center>

	<form action="<%=request.getContextPath()%>/list.do" method="post" id="form1">
		查询名字:<input type="text" name="name" size="4" value="${emp.name}">
		查询性别:<select name="sex">
		<option value="" selected="selected">请选择性别</option>
		<option value="男">男</option>
		<option value="女">女</option>
		</select>
	</select>
		选择部门:<select name="did">
		<option value="" selected="selected">请选择部门</option>
		<c:forEach items="${deptlist}" var="deptlist">
			<option value="${deptlist.did}">${deptlist.deptbh}</option>
		</c:forEach>
	</select>

		<input type="submit" value="查询">
	</form>
	<a href="<%=request.getContextPath()%>/deptselect.do">去部门</a>
</center>

<br>
<table border="0" align="center">
		<tr align="center">
			<td>员工编号</td>
			<td>员工姓名</td>
			<td>员工年龄</td>
			<td>员工性别</td>
			<td>员工邮箱</td>
			<td>员工爱好</td>
			<td>部门名称</td>
			<td><a href="toadd.do?eid=${emp.eid}"><font color="red">添加员工</font></a></td>
		</tr>
			<c:forEach items="${list}" var="emp" varStatus="rs">
				<tr align="center">
					<td>${rs.index+1}</td>
					<td>${emp.name}</td>
					<td>${emp.age}</td>
					<td>${emp.sex}</td>
					<td>${emp.mail}</td>
					<td>${emp.ah}</td>
					<td>${emp.dept.deptbh}</td>
					<td><a href="delete.do?eid=${emp.eid}">删除</a>|<a href="selectid.do?eid=${emp.eid}">修改</a>
					</td>
				</tr>
			</c:forEach>
	</form>
</table>
<br>
<center>
    <li style="display: inline">
         <a href="<%=request.getContextPath()%>/list.do?nowpage=1" onclick="aa(this)">首页</a>&nbsp;&nbsp;&nbsp;
    </li>

        <c:if test="${page!=1}">
    <li style="display: inline">
            <a href="<%=request.getContextPath()%>/list.do?nowpage=${page-1}" onclick="aa(this)">上一页</a>&nbsp;&nbsp;&nbsp;
    </li>
        </c:if>



	<c:if test="${page!=totalpage}">
    <li style="display: inline">
		<a href="<%=request.getContextPath()%>/list.do?nowpage=${page+1}" onclick="aa(this)">下一页</a>&nbsp;&nbsp;&nbsp;
    </li>
	</c:if>


    <li style="display: inline">
	    <a href="<%=request.getContextPath()%>/list.do?nowpage=${totalpage}" onclick="aa(this)">尾页</a>&nbsp;&nbsp;&nbsp;
    </li>
	当前第${page}页&nbsp;&nbsp;&nbsp;
	一共${totalpage}页&nbsp;&nbsp;&nbsp;
</center>
</body>
</html>
