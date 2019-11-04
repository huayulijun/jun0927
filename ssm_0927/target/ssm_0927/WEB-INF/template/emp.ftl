<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>emp主页面</title>
</head>
<body>
<h4 align="center">员工信息</h4>
<center>

    <form action="list.do" method="post" id="form1">
        查询名字:<input type="text" name="name" size="4">
        查询性别:<select name="sex">
            <option value="" selected="selected">请选性别</option>
            <option value="男">男</option>
            <option value="女">女</option>
        </select>
        </select>
        选择部门:<select name="did">
            <option value="" selected="selected">请选部门</option>
            <#list deptlist as deptlist>
                <option value="${deptlist.did}">${deptlist.deptbh}</option>
            </#list>
        </select>&nbsp;&nbsp;&nbsp;

        <input type="submit" value="查询">
    </form>
    <a href="deptselect.do">去部门</a>
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
        <td>增删改操作</td>
    </tr>
    <#list list as emp>
        <tr align="center">
            <td>${emp_index+1}</td>
            <td>${emp.name}</td>
            <td>${emp.age}</td>
            <td>${emp.sex}</td>
            <td>${emp.mail}</td>
            <td>${emp.ah}</td>
            <td>${emp.dept.deptbh}</td>
            <td><a href="toadd.do?eid=${emp.eid}"><font color="#7fff00">添加</font></a>|
                <a href="delete.do?eid=${emp.eid}"><font color="red"></font>删除</a>|
                <a href="selectid.do?eid=${emp.eid}"><font color="#ff4d84"></font>修改</a>
            </td>
        </tr>
    </#list>
    </form>
</table>
<br>

<center>
        <a href="list.do?nowpage=1">首页</a>&nbsp;&nbsp;&nbsp;

    <#if page!=1>
        <a href="list.do?nowpage=${page-1}">上一页</a>&nbsp;&nbsp;&nbsp;
    <#else>
        <a href="#">上一页</a>&nbsp;&nbsp;&nbsp;
    </#if>

    <#if page!=totalpage>
        <a href="list.do?nowpage=${page+1}">下一页</a>&nbsp;&nbsp;&nbsp;
    <#else>
        <a href="#">下一页</a>&nbsp;&nbsp;&nbsp;
    </#if>

    当前第${page}页&nbsp;&nbsp;&nbsp;
    一共${totalpage}页&nbsp;&nbsp;&nbsp;
    <a href="list.do?nowpage=${totalpage}">尾页</a>&nbsp;&nbsp;&nbsp;

</center>
</body>
</html>