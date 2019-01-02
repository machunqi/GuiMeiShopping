<%--
  Created by IntelliJ IDEA.
  User: machunqi
  Date: 2019-01-02
  Time: 03:56
  To change this template use File | Settings | File Templates.
--%>

<%--管理员安全设置修改管理员密码页面--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员安全设置修改管理员密码页面</title>

    <base href="<%=request.getContextPath() %>/" />
    <%@include file="../../../pages/beforePages/layUI.jsp"%>
    <style>
        .personWarp{
            height: 100%;
            width: 75%;
            overflow: hidden;
            margin: auto;
            background-color: #ffffff;
            padding-left:25%;
            font-size: 16px;
            color: #696969;
        }

        .personWarp input{
            margin-top: 20px;
        }
        input[type='text']{
            border-radius: 5px;
            height: 40px;
            font-size: 15px;
            padding-left: 10px;
        }
        input[name='id']{
            background-color: #999999;
        }
        input[type='submit']{
            width: 225px;
        }
    </style>
</head>
<body>
<div class="personWarp">
    <h1 style="color: #FD482C">管理员密码修改</h1>
    <form action="/doSuperuser?action=updateById" method="post">

        <img src="/static/images/icon/${sessionScope.Superuser.userImage}" width="40px">
        用户ID:${sessionScope.Superuser.id}<br>



        管理员姓名:${sessionScope.Superuser.userName}<br>

        管理员账号:${sessionScope.Superuser.userLoginName}<br>

        <label>请输入新密码:</label>
        <input type="text"  name="userPassword" /><br>



        <input class="layui-btn layui-btn-lg" type="submit"  value="保存资料"/>
        <input  class="layui-btn layui-btn-primary"  type="reset" value="重置" />

    </form>

</div>

</body>
</html>