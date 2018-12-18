<%--
  Created by IntelliJ IDEA.
  User: ZXJ
  Date: 2018/12/11
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>table模块快速使用</title>
    <link rel="stylesheet" href="static/layui/css/layui.css" media="all">
    <script rel="stylesheet" src="static/layui/layui.js"></script>
</head>
<body>

<table id="demo" lay-filter="test">
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
            <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
            <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
        </div>
    </script>
</table>






</body>
</html>
