<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改主页面</title>
</head>
<body  align="center">
<h3>修改员工</h3>
<form action="update.do" method="post">
    <center>
    <input type="hidden" name="eid" value="${emp.eid}" ><br>
    姓名:<input type="text" name="name"  value="${emp.name}"  ><br>
    年龄:<input type="text" name="age"  value="${emp.age}"  ><br>
    性别:男.<input type="radio"  name="sex" value="男" <#if emp.sex == '男'>checked="checked"</#if>>
    女.<input type="radio" name="sex" value="女"  <#if emp.sex == '女'>checked="checked"</#if>><br>
    邮箱:<input type="text" name="mail" value="${emp.mail}" placeholder="登录名@主机名.域名"><br>
    爱好:<input type="text" name="ah"  value="${emp.ah}"  ><br>
    部门:<select name="did">
            <#list deptlist as deptlist>
                <#if emp.did==deptlist.did>
                    <option value="${deptlist.did}" selected="selected">${deptlist.deptbh}</option>
                    <#else>
                     <option value="${deptlist.did}">${deptlist.deptbh}</option>
                </#if>

            </#list>
    </select><br>
    <a href="list.do">返回</a>
    <input type="submit" value="确定修改">
    </center>
</form>
</body>
</html>