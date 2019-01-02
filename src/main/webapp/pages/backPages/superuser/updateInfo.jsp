<%--
  Created by IntelliJ IDEA.
  User: machunqi
  Date: 2019-01-02
  Time: 01:04
  To change this template use File | Settings | File Templates.
--%>

<%--管理员信息修改页面--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员信息修改页面</title>

    <base href="<%=request.getContextPath()%>/"/>
    <%@include file="../../../pages/beforePages/layUI.jsp"%>
    <style>
        .personWarp{
            height: 400px;
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
        input[name='stuId']{
            background-color: #999999;
        }
        input[type='submit']{
            width: 225px;
            background-color: #009f95;
        }

        span{
            font-family:Microsoft YaHei, Segoe UI, Tahoma, Arial, Verdana, sans-serif, "楷体";
            font-size:32px;
            color: #2E2D3C;
        }

    </style>

</head>
<body>
<div class="personWarp">
    <form action="/doSuperuser?action=updateById" method="post">
        <label>用户ID:</label>
        <input type="text" name="id" value="${superuser.id}" readonly/><br>

        <label>管理员姓名:</label>
        <input type="text" name="userName" value="${superuser.userName}" /><br>

        <label>管理员账号:</label>
        <input type="text" name="userName" value="${superuser.userName}" /><br>

        <label>管理员密码:</label>
        <input type="hidden"  name="sellerPassword" value="${superuser.sellerPassword}" /><br>

        <label>管理员性别:</label>
        <input type="radio" name="userSex" value="男" ${superuser.userSex=='男'?'checked':''}/>男
        <input type="radio" name="userSex" value="女" ${superuser.userSex=='女'?'checked':''}/>女<br>

        <label>管理员身份证号 :</label>
        <input type="date" name="userID" value="${superuser.userID}"  /><br>

        <label>管理员头像 :</label>
        <input type="file" name="userImage" value="${superuser.userImage}" />
        <img src="/static/images/icon${superuser.userImage}" width="40px">
        <br>

        <label>管理员状态 :</label>
        <input type="text" name="userStatus" value="${superuser.userStatus}" /><br>



        <input class="layui-btn layui-btn-lg" type="submit"  value="保存资料"/>
        <input  class="layui-btn layui-btn-primary"  type="reset" value="重置" />
    </form>
</div>
</body>
</html>
