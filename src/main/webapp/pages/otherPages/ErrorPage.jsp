<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<base href="<%=request.getContextPath() %>/" />
<script>
    <c:choose>
        <c:when test="${param.msg == '0'}">
            alert("账号密码不正确或该账号处于冻结状态！");
            location = "/pages/beforePages/superuser/login.html";
        </c:when>
        <c:when test="${param.msg == '1'}">
            alert("请先登录再访问！");
            location = "/pages/beforePages/superuser/login.html";
        </c:when>
        <c:when test="${param.msg == '2'}">
            alert("验证码输入错误！");
            location = "/pages/beforePages/superuser/login.html";
        </c:when>




    </c:choose>
</script>


