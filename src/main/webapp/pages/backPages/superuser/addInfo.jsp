<%--
  Created by IntelliJ IDEA.
  User: machunqi
  Date: 2018-12-30
  Time: 03:07
  To change this template use File | Settings | File Templates.
--%>

<%--管理员信息增加页面--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员信息增加页面</title>

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
    <form action="/doSuperuser?action=add" method="post" >
        <span>添加管理员</span><br>

        <%--<label>用户ID:</label>--%>
        <%--<input type="text" name="id" /><br>--%>

        <label>管理员姓名:</label>
        <input type="text" name="userName"  /><br>

        <label>管理员账号:</label>
        <input type="text" name="userName"  /><br>

        <label>管理员密码:</label>
        <input type="password"  name="userPassword"  /><br>

        <label>管理员性别:</label>
        <input type="radio" name="userSex" value="男" />男
        <input type="radio" name="userSex" value="女" />女<br>

        <label>管理员身份证号 :</label>
        <input type="text" name="userId"  /><br>

        <%--<label>管理员头像 :</label>--%>
        <%--<input type="file" name="userImage"  />--%>
        <%--<img src="/static/images/icon ${sessionScope.Superuser.userImage}" width="40px">--%>
        <%--<br>--%>

        <script>
            function checkImage(val) {
                var type = val.substring(val.lastIndexOf(".")+1);
                var types = new Array("gif","bmp","jpg","png");
                var status = false;
                for(var i=0;i<types.length;i++){
                    if(type.toLowerCase()==types[i]){
                        status = true;
                        break;
                    }
                }
                if(!status){
                    alert("上传文件类型不是图像！");
                    document.getElementById("sub").disabled=true;
                }else{
                    document.getElementById("sub").disabled=false;
                }
            }
        </script>

        <label>管理员头像 :</label>
        <input type="file" name="userImage" onchange="checkImage(this.value)" />
        <br>

        <label>管理员状态 :</label>
        <input type="radio" name="userStatus" value="0" />未冻结
        <input type="radio" name="userStatus" value="1" />已冻结<br>



        <input class="layui-btn layui-btn-lg" type="submit"  value="保存资料"/>
        <input  class="layui-btn layui-btn-primary"  type="reset" value="重置" />
    </form>
</div>
</body>
</html>