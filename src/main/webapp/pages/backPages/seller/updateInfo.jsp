<%--
  Created by IntelliJ IDEA.
  User: machunqi
  Date: 2019-01-02
  Time: 01:04
  To change this template use File | Settings | File Templates.
--%>

<%--商家信息修改页面--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家信息修改页面</title>

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
    <form action="/doSeller?action=updateById" method="post">
        <label>商家ID:</label>
        <input type="text" name="id" value="${Seller.id}" readonly/><br>

        <label>姓名:</label>
        <input type="text" name="stuName" value="${Seller.stuName}" /><br>

        <label>商家性别:</label>
        <input type="radio" name="sellerSex" value="男" ${Seller.sellerSex=='男'?'checked':''}/>男
        <input type="radio" name="sellerSex" value="女" ${Seller.sellerSex=='女'?'checked':''}/>女<br>

        <label>密码:</label>
        <input type="hidden"  name="sellerPassword" value="${Seller.sellerPassword}" /><br>

        <label>商家生日 :</label>
        <input type="date" name="sellerBirthday" value="${Seller.sellerBirthday}"  /><br>

        <label>商家身份证号 :</label>
        <input type="text" name="sellerIDCard" value="${Seller.sellerIDCard}" /><br>

        <label>商家邮箱 :</label>
        <input type="text" name="sellerEmail" value="${Seller.sellerEmail}" /><br>

        <label>商家电话 :</label>
        <input type="text" name="sellerTel" value="${Seller.sellerTel}" /><br>

        <label>商家地址 :</label>
        <input type="text" name="sellerAddress" value="${Seller.sellerAddress}" /><br>


        <input class="layui-btn layui-btn-lg" type="submit"  value="保存资料"/>
        <input  class="layui-btn layui-btn-primary"  type="reset" value="重置" />
    </form>
</div>
</body>
</html>
