<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>dept主页面</title>
</head>
<body>
<h3 align="center">部门信息</h3>
<table align="center">
    <tr align="center">
        <td>编号</td>
        <td>部门</td>
    </tr>
        <#list listdept as dept >
            <tr>
                <td>${dept_index+1}</td>
                <td>${dept.deptbh }</td>
            </tr>
        </#list>
    <tr><td><a href="list.do"><center>返回员工</center></a></td></tr>
</table>
</body>
</html>