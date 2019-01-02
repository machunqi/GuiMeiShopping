<%--
  Created by IntelliJ IDEA.
  User: machunqi
  Date: 2018-12-30
  Time: 03:09
  To change this template use File | Settings | File Templates.
--%>

<%--管理员信息查询--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员信息查询</title>
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

    <form action="/doSuperuser?action=unionQuery" method="post">
        <label>管理员ID:</label>
        <input type="text" name="id" placeholder="请输入管理员ID" />
        <label>管理员姓名:</label>
        <input type="text" name="userName" placeholder="请输入管理员姓名"  />
        <label>性别:</label>
        <select name="userSex">
            <option value="">请选择</option>
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
                    <th>管理员ID</th>
                    <th>管理员姓名</th>
                    <th>管理员账号</th>
                    <th>管理员性别</th>
                    <th>管理员身份证号码</th>
                    <th>管理员头像</th>
                    <th>管理员状态</th>
                    <th colspan="2">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.Page.pageData}" var="superuser">
                    <tr>
                        <td>${superuser.id}</td>
                        <td>${superuser.userName}</td>
                        <td>${superuser.userLoginName}</td>
                        <td>${superuser.userSex}</td>
                        <td>${superuser.userId}</td>
                        <td><img width="40px" src="/static/images/icon/${superuser.userImage}"/></td>
                        <td>${superuser.userStatus}</td>
                        <td><a id="del" class="layui-btn" href="/doSuperuser?action=delById&id=${superuser.id}">删除</a></td>
                        <td><a  class="layui-btn" href="/doSuperuser?action=queryById&id=${superuser.id}">修改</a></td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="6">
                        <%@include file="/pages/otherPages/PageUtil.jsp"%>
                    </td>
                </tr>
                </tfoot>

            </table>
            <script>
                function jump() {
                    var number = document.getElementById("jumpNumber").value;
                    open("/doSuperuser?action=queryAll&pageNumber="+number,"iframe_context");
                }
            </script>
        </c:when>
        <c:otherwise>
            <h2>暂无管理员信息</h2>
        </c:otherwise>
    </c:choose>
</body>
</html>