<%--
  Created by IntelliJ IDEA.
  User: machunqi
  Date: 2018-12-27
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--html改jsp 添加代码不会css样式不生效--%>
<!DOCTYPE HTML PUBLIC"-//W3C//DTD HTML 4.01Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<base href="<%=request.getContextPath() %>/" />
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <script src="../../../static/js/menu/adapter.js"></script> <!--rem适配js-->

    <%@include file="../../../pages/beforePages/layUI.jsp"%>

    <link rel="stylesheet" href="../../../static/css/menu/base.css"> <!--初始化文件-->
    <link rel="stylesheet" href="../../../static/css/menu/menu.css"> <!--主样式-->
    <link rel="stylesheet" href="../../../static/css/menu/index.css"> <!--主样式-->

</head>
<body>
    <div id="main" class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <iframe name="iframe_context" frameborder="0" id="context" src=""></iframe>
        </div>
    </div>


<div id="menu">
        <!--隐藏菜单-->
        <div id="ensconce">
            <h2>
                <img src="../../../static/images/menu/show.png" alt="">
                管理员菜单
            </h2>
        </div>

        <!--显示菜单-->
        <div id="open">
            <div class="navH">
                管理员菜单
                <span><img class="obscure" src="../../../static/images/menu/obscure.png" alt=""></span>
            </div>
            <div class="navBox">
                <ul>
                    <li>
                        <h2 class="obtain">管理员管理<i></i></h2>
                        <div class="secondary">
                            <h3><a target="iframe_context" href="">个人资料</a></h3>
                        </div>
                    </li>
                    <li>
                        <h2 class="obtain">商家管理<i></i></h2>
                        <div class="secondary">
                            <h3>查询商家</h3>
                            <h3>添加商家</h3>
                            <h3>修改商家</h3>
                            <h3>删除商家</h3>
                        </div>
                    </li>
                    <li>
                        <h2 class="obtain">顾客管理<i></i></h2>
                        <div class="secondary">
                            <h3>查询顾客</h3>
                            <h3>添加顾客</h3>
                            <h3>修改顾客</h3>
                            <h3>删除顾客</h3>

                        </div>
                    </li>
                    <li>
                        <h2 class="obtain">大分类管理<i></i></h2>
                        <div class="secondary">
                            <h3>查询大分类</h3>
                            <h3>添加大分类</h3>
                            <h3>修改大分类</h3>
                            <h3>删除大分类</h3>
                        </div>
                    </li>
                    <li>
                        <h2 class="obtain">小分类管理<i></i></h2>
                        <div class="secondary">
                            <h3>查询小分类</h3>
                            <h3>添加小分类</h3>
                            <h3>修改小分类</h3>
                            <h3>删除小分类</h3>
                        </div>
                    </li>
                    <li>
                        <h2 class="obtain">商品管理<i></i></h2>
                        <div class="secondary">
                            <h3>查询商品</h3>
                            <h3>添加商品</h3>
                            <h3>修改商品</h3>
                            <h3>删除商品</h3>
                        </div>
                    </li>
                    <li>
                    <h2 class="obtain">公告管理<i></i></h2>
                    <div class="secondary">
                        <h3>查询公告</h3>
                        <h3>添加公告</h3>
                        <h3>修改公告</h3>
                        <h3>删除公告</h3>
                    </div>
                    </li>

                </ul>
            </div>
        </div>



    </div>

    <script src="../../../static/js/menu/menu.js"></script> <!--控制js-->

</body>
</html>
