<%--
  Created by IntelliJ IDEA.
  User: ZXJ
  Date: 2018/12/10
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>人口管理表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="static/layui/css/layui.css" media="all">
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
</head>
<body>
    <div class="demoTable">
        搜索姓名：
        <div class="layui-inline">
            <input class="layui-input" name="pname" id="demoReload" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>
    <table id="demo" lay-filter="test"></table>

<%--<div id="div">
    <form action="add" method="post">
        <span>姓名</span>
        <input type="text" name="pname"/>
        <span>身份证号</span>
        <input type="text" name="pno"/>
        <span>性别</span>
        <input type="radio" name="gender">
        <input type="submit" value="提交"/>
    </form>
</div>--%>
    <script src="static/layui/layui.js"></script>
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" onclick="dj()" lay-event="getCheckData">增加</button>
            <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">选中的个数</button>
            <button class="layui-btn layui-btn-sm" lay-event="isAll">是否全选</button>
            <button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="batchDelete">批量删除</button>
        </div>
    </script>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script type="text/javascript">

        layui.use('table', function(){
            var table = layui.table;

            //第一个实例
            table.render({
                elem: '#demo'
                ,url: 'persons' //数据接口
                ,toolbar: '#toolbarDemo'
                ,even: true
                ,page: true //开启分页
                ,id: 'testReload'
                ,cols: [[ //表头
                    {type:'checkbox', fixed: 'left'}
                    ,{field: 'pid', title: 'ID', width:80, sort: true, fixed: 'left'}
                    ,{field: 'pname', title: '姓名', width:80, sort: true}
                    ,{field: 'pgender', title: '性别', width:80}
                    ,{field: 'paddress', title: '城市', width:80}
                    ,{field: 'pno', title: '身份证号', width: 177}
                    ,{field: 'page', title: '年龄', width: 80, sort: true}
                    ,{field: 'pphone', title: '手机号', width: 177, sort: true}
                    ,{field: 'pphoto', title: '照片', width: 80}
                    ,{field: 'pbirthday', title: '生日', width: 135, sort: true}
                    ,{fixed: 'right', title: '操作', width:150, align:'center', toolbar: '#barDemo'}
                ]]
            });

            //头工具栏事件
            table.on('toolbar(test)', function(obj){
                var checkStatus = table.checkStatus(obj.config.id);
                //layer.msg("hello");
                switch(obj.event){
                    /*case 'getCheckData':
                        var data = checkStatus.data;
                        layer.alert(JSON.stringify(data));
                        break;*/
                    case 'getCheckLength':
                        var data = checkStatus.data;
                        layer.msg('选中了：'+ data.length + ' 个');
                        break;
                    case 'isAll':
                        layer.msg(checkStatus.isAll ? '全选': '未全选');
                        break;
                    case 'batchDelete':
                        layer.confirm('真的删除行么', function(data) {
                            //layer.close(index);
                            for (var i = 0; i <= data.length; i++) {
                                //layer.alert("qwrwefasda");
                                $.ajax({
                                    url: "delete",
                                    type: "get",
                                    data: {'pid': data[i].pid},
                                    dataType: "json",
                                    async: true,
                                    cache: false,
                                    success: function (data) {

                                    }
                                })
                            }
                        });
                };
            });

            table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data; //获得当前行数据
                //var data = JSON.stringify(data1.field);
                var pid=data.pid;
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象
                if(layEvent === 'detail'){ //查看
                    layer.open({
                        content: '查看',
                        yes: function(index, layero){
                            //do something
                            layer.alert(JSON.stringify(data));
                            layer.close(index); //如果设定了yes回调，需进行手工关闭
                        }
                    });
                    /*layer.open({
                        anim: 4,
                        type: 0,
                        content: JSON.stringify(data)
                    });*/
                    //do somehing
                } else if(layEvent === 'del'){ //删除
                    layer.confirm('真的删除行么', function(index){
                        console.log(obj.data);
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                        $.ajax({
                            url:"delete",
                            type:"get",
                            data:{'pid':data.pid},
                            dataType:"json",
                            async:true,
                            cache:false,
                            success:function (data) {

                            }
                        })
                    });
                } else if(layEvent === 'edit'){ //编辑
                    //do something
                    layer.open({
                        type: 2,
                        area: ['500px', '350px'],
                        content: 'toUpdate/'+pid+'',
                        cancel: function (index) {
                            table.reload('testReload');
                            layer.close(index);
                        }
                    });

                    //同步更新缓存对应的值
                    /*obj.update({
                        username: '123'
                        ,title: 'xxx'
                    });*/
                }
            });

            var $ = layui.$, active = {
                reload: function(){
                    var demoReload = $('#demoReload');

                    //执行重载
                    table.reload('testReload', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        ,where: {
                            key: {
                                pname: demoReload.val()
                            }
                        }
                    });
                }
            };

            $('.demoTable .layui-btn').on('click', function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });

            /*table.on('toolbar(test)', function(obj){
                alert("阿薩");
                layer.msg('删除');
                var checkStatus = table.checkStatus(obj.config.id);
                alert("哪家歲");
                switch(obj.event){
                    case 'add':
                        layer.msg('添加');
                        break;
                    case 'delete':
                        layer.msg('删除');
                        break;
                    case 'update':
                        layer.msg('编辑');
                        break;
                };
            });*/

        });
    </script>
    <%--<script type="text/javascript">
        $(function () {
            alert("阿薩");
            layui.use('table', function(){
                var table = layui.table;
                alert("阿薩");
                table.on('toolbar(test)', function(obj){
                    /*layer.msg('删除');
                    var checkStatus = table.checkStatus(obj.config.id);
                    alert("哪家歲");*/
                    switch(obj.event){
                        case 'add':
                            layer.msg('添加');
                            break;
                        case 'delete':
                            layer.msg('删除');
                            break;
                        case 'update':
                            layer.msg('编辑');
                            break;
                    };
                });
            });
        });
    </script>--%>

    <script type="text/javascript">
        function dj() {
            //alert("沒說得很好");
            layer.open({
                type: 2,
                area: ['500px', '300px'],
                content: 'toAdd',
                cancel: function (index) {
                    layui.table.reload('testReload');
                    layer.close(index);
                }
            });
        }
    </script>
</body>
</html>
