<%--
  Created by IntelliJ IDEA.
  User: machunqi
  Date: 2018-12-30
  Time: 03:09
  To change this template use File | Settings | File Templates.
--%>

<%--查询顾客信息页面--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询顾客信息页面</title>
    <base href="<%=request.getContextPath() %>/" />
    <%@include file="/pages/beforePages/layUI.jsp"%>
    <style>
        table{
            background-color: #fffffb;
            text-align: center;
            margin: auto;
        }

        input{
            border-radius: 5px;
            height: 30px;
            font-size: 15px;
            padding-left: 5px;
        }

        #del{
            background-color: red;
        }
    </style>
</head>
<body>
    <div>查询顾客信息</div>
    <form action="/doCustomer?action=unionQuery" method="post">
        <label>顾客ID:</label>
        <input type="text" name="id" placeholder="请输入顾客ID" />
        <label>顾客姓名:</label>
        <input type="text" name="cusName" placeholder="请输入顾客姓名"  />
        <label>性别:</label>
        <select name="cusSex">
            <option value="">-请选择-</option>
            <option value="男">男</option>
            <option value="女">女</option>
        </select>
        <input class="layui-btn " type="submit"  value="查询"/>
    </form>
    <c:choose>
        <c:when test="${not empty sessionScope.Page.pageData}">
            <table class="layui-table" width="80%">
                <thead>
                <tr>
                    <th>顾客ID</th>
                    <th>顾客姓名</th>
                    <th>顾客账号</th>
                    <th>顾客邮箱</th>
                    <th>顾客性别</th>
                    <th>顾客头像</th>
                    <th>顾客爱好</th>
                    <th>顾客身份证号</th>
                    <th>顾客生日</th>
                    <th colspan="2">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.Page.pageData}" var="cus">
                    <tr>
                        <td>${cus.id}</td>
                        <td>${cus.cusName}</td>
                        <td>${cus.cusLoginName}</td>
                        <td>${cus.cusEmail}</td>
                        <td>${cus.cusSex}</td>
                        <td><img width="40px" src="/static/images/icon/${cus.cusPhoto}"/></td>
                        <td>${cus.cusHobby}</td>
                        <td>${cus.cusIdCard}</td>
                        <td>${cus.cusBirthday}</td>
                        <td><a id="del" class="layui-btn" href="/doCustomer?action=delById&id=${cus.id}">删除</a></td>
                        <td><a  class="layui-btn" href="/doCustomer?action=queryById&id=${cus.id}">修改</a></td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="6">
                        <%@include file="/pages/otherPages/PageUtil.jsp"%>
                    </td>
                    </td>
                </tr>
                </tfoot>

            </table>
            <script>
                function jump() {
                    var number = document.getElementById("jumpNumber").value;
                    open("/doCustomer?action=queryAll&pageNumber="+number,"iframe_context");
                }
            </script>
        </c:when>
        <c:otherwise>
            <h2>暂无顾客信息</h2>
        </c:otherwise>
    </c:choose>
</body>
</html>
