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
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <script src="../../../static/js/menu/adapter.js"></script> <!--rem适配js-->


    <base href="<%=request.getContextPath() %>/" />
    <%@include file="/pages/beforePages/layUI.jsp"%>
    <link rel="stylesheet" href="../../../static/css/menu/base.css"> <!--初始化文件-->
    <link rel="stylesheet" href="../../../static/css/menu/menu.css"> <!--主样式-->
    <link rel="stylesheet" href="../../../static/css/menu/index.css"> <!--主样式-->

    <style type="text/css">
        html{
            height: 100%;
        }
        body {
            height: 100%;
            align-items: center;
            background: #642B73;
            background: linear-gradient(to bottom, #C6426E, #642B73);
            /*font-family: 'Open Sans', sans;*/
            justify-content: center;
            -webkit-perspective: 1800px;
            perspective: 1800px;
            text-align: center;
            margin: 0 5px;
            width: 100%;
            border: #0000FF 1px solid;

        }
        #head{
            position: relative;
            z-index: -5;
        }
    </style>

</head>
<body class="layui-layout-body">
        <div id="head"  class="layui-header">
            <div class="layui-logo">
                <img style="margin-left: 15px" width="260px" src="">
            </div>
            <div class="head">
                <h1 style="color: #e2e2e2"> 欢迎管理员&nbsp;<span style="color:#ff3b31;font-size: large ">${sessionScope.Superuser.userName}</span> &nbsp;进入贵美后台管理系统</h1>
            </div>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <img src="/static/images/icon/${sessionScope.Superuser.userImage}" class="layui-nav-img" width="40px">
                        ${sessionScope.Superuser.userName}
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a target="iframe_context" href="/pages/backPages/superuser/personalDataInfo.jsp">基本资料</a></dd>
                        <dd><a target="iframe_context" href="/pages/backPages/superuser/securitySettings.jsp">安全设置</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a id="outPage" href="" class="layui-icon ">&#x1007;</a></li>
            </ul>
        </div>

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
                                <h2 class="obtain">个人资料<i></i></h2>
                                <div class="secondary">
                                    <h3><a target="iframe_context" href="/pages/backPages/superuser/personalDataInfo.jsp">个人资料</a></h3>
                                    <h3><a target="iframe_context" href="/pages/backPages/superuser/securitySettings.jsp">安全设置</a></h3>


                                    <%--<h3><a target="iframe_context" href="/doSuperuser?action=queryById&id=${sessionScope.Superuser.id}">安全设置</a></h3>--%>
                                </div>
                            </li>
                            <li>
                                <h2 class="obtain">管理员管理<i></i></h2>
                                <div class="secondary">
                                    <h3><a target="iframe_context" href="/doSuperuser?action=queryAll&pageNumber=1">查询管理员</a></h3>
                                    <h3><a target="iframe_context" href="/pages/backPages/superuser/addInfo.jsp">添加管理员</a></h3>
                                    <h3><a target="iframe_context" href="/pages/backPages/superuser/updateInfo.jsp">修改管理员</a></h3>
                                    <h3><a target="iframe_context" href="/doSeller?action=queryAll&pageNumber=1">删除管理员</a></h3>
                                </div>
                            </li>
                            <li>
                                <h2 class="obtain">商家管理<i></i></h2>
                                <div class="secondary">
                                    <h3><a target="iframe_context" href="/doSeller?action=queryAll&pageNumber=1">查询商家</a></h3>
                                    <h3><a target="iframe_context" href="/pages/backPages/seller/addInfo.jsp">添加商家</a></h3>
                                    <h3><a target="iframe_context" href="/doSeller?action=queryAll&pageNumber=1">修改商家</a></h3>
                                    <h3><a target="iframe_context" href="/doSeller?action=queryAll&pageNumber=1">删除商家</a></h3>
                                </div>
                            </li>
                            <li>
                                <h2 class="obtain">顾客管理<i></i></h2>
                                <div class="secondary">
                                    <h3><a target="iframe_context" href="/doCustomer?action=queryAll&pageNumber=1">查询顾客</a></h3>
                                    <h3><a target="iframe_context" href="/pages/backPages/customer/addInfo.jsp">添加顾客</a></h3>
                                    <h3><a target="iframe_context" href="/pages/backPages/customer/updateInfo.jsp">修改顾客</a></h3>
                                    <h3><a target="iframe_context" href="/pages/backPages/customer/updateInfo.jsp">删除顾客</a></h3>

                                </div>
                            </li>
                            <li>
                                <h2 class="obtain">大分类管理<i></i></h2>
                                <div class="secondary">
                                    <h3><a target="iframe_context" href="/doBigClass?action=queryAll&pageNumber=1">查询大分类</a></h3>
                                    <h3><a target="iframe_context" href="/pages/backPages/bigClass/addInfo.jsp">添加大分类</a></h3>
                                    <h3><a target="iframe_context" href="/doCustomer?action=queryAll&pageNumber=1">修改大分类</a></h3>
                                    <h3><a target="iframe_context" href="/doCustomer?action=queryAll&pageNumber=1">删除大分类</a></h3>
                                </div>
                            </li>
                            <li>
                                <h2 class="obtain">小分类管理<i></i></h2>
                                <div class="secondary">
                                    <h3><a target="iframe_context" href="/doSmallClass?action=queryAll&pageNumber=1">查询小分类</a></h3>
                                    <h3><a target="iframe_context" href="/pages/backPages/smallClass/addInfo.jsp">添加小分类</a></h3>
                                    <h3><a target="iframe_context" href="/doCustomer?action=queryAll&pageNumber=1">修改小分类</a></h3>
                                    <h3><a target="iframe_context" href="/doCustomer?action=queryAll&pageNumber=1">删除小分类</a></h3>
                                </div>
                            </li>
                            <li>
                                <h2 class="obtain">商品管理<i></i></h2>
                                <div class="secondary">
                                    <h3><a target="iframe_context" href="/doGoods?action=queryAll&pageNumber=1">查询商品</a></h3>
                                    <h3><a target="iframe_context" href="/doGoods?action=queryAll&pageNumber=1">添加商品</a></h3>
                                    <h3><a target="iframe_context" href="/doGoods?action=queryAll&pageNumber=1">修改商品</a></h3>
                                    <h3><a target="iframe_context" href="/doGoods?action=queryAll&pageNumber=1">删除商品</a></h3>
                                </div>
                            </li>
                            <li>
                            <h2 class="obtain">公告管理<i></i></h2>
                            <div class="secondary">
                                <h3><a target="iframe_context" href="/doAnnouncement?action=queryAll&pageNumber=1">查询公告</a></h3>
                                <h3><a target="iframe_context" href="/doAnnouncement?action=queryAll&pageNumber=1">添加公告</a></h3>
                                <h3><a target="iframe_context" href="/doAnnouncement?action=queryAll&pageNumber=1">修改公告</a></h3>
                                <h3><a target="iframe_context" href="/doAnnouncement?action=queryAll&pageNumber=1">删除公告</a></h3>
                            </div>
                            </li>
                            <li>
                                <h2 class="obtain">订单管理<i></i></h2>
                                <div class="secondary">
                                    <h3><a target="iframe_context" href="/doOrderse?action=queryAll&pageNumber=1">查询订单</a></h3>
                                    <%--<h3><a target="iframe_context" href="/doOrderse?action=queryAll&pageNumber=1">添加订单</a></h3>--%>
                                    <h3><a target="iframe_context" href="/doOrderse?action=queryAll&pageNumber=1">修改订单</a></h3>
                                    <h3><a target="iframe_context" href="/doOrderse?action=queryAll&pageNumber=1">删除订单</a></h3>
                                </div>
                            </li>
                            <li>
                                <h2 class="obtain">折扣管理<i></i></h2>
                                <div class="secondary">
                                    <h3><a target="iframe_context" href="/doDiscount?action=queryAll&pageNumber=1">查询折扣</a></h3>
                                    <h3><a target="iframe_context" href="/doDiscount?action=queryAll&pageNumber=1">添加折扣</a></h3>
                                    <h3><a target="iframe_context" href="/doDiscount?action=queryAll&pageNumber=1">修改折扣</a></h3>
                                    <h3><a target="iframe_context" href="/doDiscount?action=queryAll&pageNumber=1">删除折扣</a></h3>
                                </div>
                            </li>

                        </ul>
                    </div>
                </div>


        </div>
    </div>

    <script src="../../../static/js/menu/menu.js"></script> <!--控制js-->
        <script>
            //JavaScript代码区域
            layui.use('element', function(){
                var element = layui.element;

            });
        </script>

</body>
</html>
