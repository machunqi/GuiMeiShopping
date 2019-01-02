<%--
  Created by IntelliJ IDEA.
  User: machunqi
  Date: 2019-01-02
  Time: 00:51
  To change this template use File | Settings | File Templates.
--%>

<%--商家信息添加页面--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家添加</title>

    <base href="<%=request.getContextPath()%>/"/>
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
    <form action="/doSeller?action=add" method="post" >
        <span>添加商家信息</span><br>

        <label>商家姓名 :</label>
        <input type="text" name="sellerName" /><br>

        <label>商家账号 :</label>
        <input type="text" name="sellerUser" /><br>

        <label>商家密码 :</label>
        <input type="text" name="sellerPassword" /><br>

        <label>商家性别 :</label>
        <input type="radio" name="sellerSex" value="男" />男
        <input type="radio" name="sellerSex" value="女" />女<br>

        <label>商家生日 :</label>
        <input type="date" name="sellerBirthday" /><br>

        <label>商家身份证号 :</label>
        <input type="text" name="sellerIDCard" /><br>

        <label>商家邮箱 :</label>
        <input type="text" name="sellerEmail" /><br>

        <label>商家电话 :</label>
        <input type="text" name="sellerTel" /><br>

        <label>商家地址 :</label>
        <input type="text" name="sellerAddress" /><br>

        <input  class="layui-btn" lay-submit  type="submit" value="添加" />
        <input  class="layui-btn layui-btn-primary"  type="reset" value="重置" />
    </form>
</div>
</body>
</html>
