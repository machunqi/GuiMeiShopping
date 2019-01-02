<%--
  Created by IntelliJ IDEA.
  User: machunqi
  Date: 2018-12-30
  Time: 03:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

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
    <form action="/doCustomer?action=add" method="post" >
        <span>添&nbsp;&nbsp;加&nbsp;&nbsp;学&nbsp;&nbsp;生</span><br>

        <%--<label>学号 :</label>--%>
        <%--<input type="text" name="stuId" readonly/><br>--%>
        <label>姓名 :</label>
        <input type="text" name="stuName" /><br>
        <label>性别 :</label>
        <input type="radio" name="stuSex" value="男" />男
        <input type="radio" name="stuSex" value="女" />女<br>
        <label>密码 :</label>
        <input type="text" name="stuPwd" /><br>
        <label>地址 :</label>
        <input type="text" name="stuAddress" /><br>
        <label>生日 :</label>
        <input type="date" name="stuBirthday" /><br>
        <input class="layui-btn layui-btn-lg" type="submit"  value="添加"/><br>
    </form>
</div>
</body>
</html>