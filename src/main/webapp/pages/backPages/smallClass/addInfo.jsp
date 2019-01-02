<%--
  Created by IntelliJ IDEA.
  User: machunqi
  Date: 2019-01-01
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加小分类</title>
    <%@ include file="/pages/beforePages/layUI.jsp"%>
    <style>
        label{
            color: azure;
            font-size: 15px;
        }
        form{
            margin: auto;
            margin-top: 30px;
            border: 1px solid #effffc;
            padding: 10px;
        }
    </style>

    <script>
        $(function () {
            /*加载大分类信息*/
            var url1 = "/doBigClass?action=ajaxQueryAll";
            $.getJSON(url1,function (responseData) {
                $.each(responseData,function (index,bigClass) {
                    $("select[name='smallBigId']").append("<option value='"+bigClass.id+"'>--"+bigClass.bigName+"--</option>")
                })
            });
            //验证小分类名称是否可用
            $("input[name='smallName']").change(function () {
                var url2 = "servlet/doSmallClass";
                var data = {action:"checkSmallName",smallName:$(this).val()}
                $.post(url2,data,function(responseData){
                    if(responseData=="exists"){
                        $("#msg").html("该小分类名称以被占用").css({color:"red","font-weight":"bold"});
                        $("input[type='submit']").prop("disabled",true);
                    }else{
                        $("#msg").html("");
                        $("input[type='submit']").prop("disabled",false);
                    }
                },"text");
            });

        });
    </script>
</head>
<body>
    <form  method="post" action="">
        <span>添&nbsp;&nbsp;加&nbsp;&nbsp;小&nbsp;&nbsp;分&nbsp;类</span><br>
        <label>小分类名称:</label>
        <input type="text" name="smallName" required lay-verify="required" placeholder="请输入小分类名称" autocomplete="off" class="layui-input"/>
            <label id="msg"></label>
        <br><br>
        <label>所属大分类</label>
        <select name="smallBigId" required lay-verify="">
            <option value="">--请选择--</option>
        </select> <br><br>
        <label>小分类描述:</label>
            <textarea name="smallText" cols="3" rows="5"></textarea>
        <br><br>

        <input  class="layui-btn" lay-submit  type="submit" value="添加" />
        <input  class="layui-btn layui-btn-primary"  type="reset" value="重置" />
    </form>

</body>
</html>
