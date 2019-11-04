<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加主页面</title>
</head>
<body  align="center">
<h3>添加员工</h3>
<form action="insert.do" method="post">
    员工名称:<input type="text" name="name" id="name"><br>
    年龄:<input type="text" name="age" ><br>
    性别:男.<input type="radio" value="男" name="sex">
    女.<input type="radio" value="女"  name="sex"><br>
    邮箱:<input type="text" name="mail" placeholder="登录名@主机名.域名"  ><br>
    爱好:<input type="text" name="ah" ><br>
    部门:<select name="did">
        <option value="0">请选择</option>
        <#list deptlist as dept >
            <option value="${dept.did}">${dept.deptbh}</option>
        </#list>
    </select><br>
    <a href="list.do">返回</a>
    <input type="submit" value="确认添加">
</form>
</body>
</html>