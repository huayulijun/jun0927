<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加页面</title>
    <script type="text/javascript"  src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">

        /*判断部门是否存在*/
        $(function () {
            $("#deptbh").blur(function () {
                $.get("${pageContext.request.contextPath}/selectdeptbh.do?deptbh="+$("#deptbh").val(),function (data) {
                    if (data == "true") {
                        $("#nameSpan").html("该部门已存在")
                        $("#deptbh").val("")
                    } else {
                        $("#nameSpan").text("")
                    }
                })
            })
        })

    </script>
</head>

<body align="center">
<c:forEach items="${deptyj}" var="yj">
    ${yj.defaultMessage}
</c:forEach>
<h3>添加部门</h3>
<form action="<%=request.getContextPath()%>/insertdept.do" method="post">
    添加部门:<input type="text" name="deptbh" id="deptbh"> <font color="red"><span id="nameSpan"></span></font><br>
    <a href="<%=request.getContextPath()%>/deptselect.do">返回</a>
<input type="submit" value="确认添加">
</form>
</body>
</html>