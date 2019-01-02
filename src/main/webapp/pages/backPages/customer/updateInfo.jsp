<%--
  Created by IntelliJ IDEA.
  User: machunqi
  Date: 2018-12-30
  Time: 03:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息修改</title>
    <base href="<%=request.getContextPath() %>/" />
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
        }
    </style>
</head>
<body>
<div class="personWarp">
    <form action="/doCustomer?action=updateById" method="post">
        <label>学号:</label>
        <input type="text" name="stuId" value="${Student.stuId}" readonly/><br>
        <label>姓名:</label>
        <input type="text" name="stuName" value="${Student.stuName}" /><br>
        <label>性别:</label>
        <input type="radio" name="stuSex" value="男" ${Student.stuSex=='男'?'checked':''} />男
        <input type="radio" name="stuSex" value="女" ${Student.stuSex=='女'?'checked':''}/>女
        <label>密码:</label>
        <input type="hidden"  name="stuPwd" value="${Student.stuPwd}" /><br>
        <label>地址:</label>
        <input type="text" name="stuAddress" value="${Student.stuAddress}" /><br>
        <label>生日:</label>
        <input type="text" name="stuBirthday"  value="${Student.stuBirthday}" /><br>
        <input class="layui-btn layui-btn-lg" type="submit"  value="保存资料"/>
    </form>
</div>
</body>
</html>