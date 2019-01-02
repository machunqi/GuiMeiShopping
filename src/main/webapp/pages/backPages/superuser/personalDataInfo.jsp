<%--
  Created by IntelliJ IDEA.
  User: machunqi
  Date: 2019-01-02
  Time: 02:07
  To change this template use File | Settings | File Templates.
--%>

<%--管理员个人资料页面--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员个人资料页面</title>

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
    <h1 style="color: #FD482C">管理员个人资料页面</h1>
    <form action="/doSuperuser?action=updateById" method="post">
        <label>用户ID:</label>
        <input type="text" name="id" value="${sessionScope.Superuser.id}" readonly /><br>

        <label>管理员姓名:</label>
        <input type="text" name="userName" value="${sessionScope.Superuser.userName}" /><br>

        <label>管理员账号:</label>
        <input type="text" name="userName" value="${sessionScope.Superuser.userLoginName}" /><br>

        <label>管理员密码:</label>
        <input type="password"  name="userPassword" value="${sessionScope.Superuser.userPassword}" readonly />
        <a href="/pages/backPages/superuser/personalDataInfo.jsp">修改密码</a><br>

        <label>管理员性别:</label>
        <input type="radio" name="userSex" value="男" ${sessionScope.Superuser.userSex=='男'?'checked':''}/>男
        <input type="radio" name="userSex" value="女" ${sessionScope.Superuser.userSex=='女'?'checked':''}/>女<br>

        <label>管理员身份证号 :</label>
        <input type="text" name="userId" value="${sessionScope.Superuser.userId}"  /><br>

        <label>管理员头像 :</label>
        <input type="file" name="userImage" value="${sessionScope.Superuser.userImage}" />
        <img src="/static/images/icon/${sessionScope.Superuser.userImage}" width="40px">
        <br>

        <label>管理员状态 :</label>
        <%--<input type="text" name="userStatus" value="${sessionScope.Superuser.userStatus}" />--%>
        <input type="radio" name="userStatus" value="0" ${sessionScope.Superuser.userStatus=='0'?'checked':''}/>未冻结
        <input type="radio" name="userStatus" value="1" ${sessionScope.Superuser.userStatus=='1'?'checked':''}/>已冻结<br>




        <input class="layui-btn layui-btn-lg" type="submit"  value="保存资料"/>
        <input  class="layui-btn layui-btn-primary"  type="reset" value="重置" />

    </form>

</div>

</body>
</html>
