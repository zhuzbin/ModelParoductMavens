<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/9/15
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/bootstrap-table-develop/src/bootstrap-table.css">
    <link rel="stylesheet" href="../css/animate.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/font-awesome.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="application/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../plugins/bootstrap-table-develop/src/bootstrap-table.js"></script>
    <script type="text/javascript" src="../js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script type="text/javascript" src="../plugins/bootstrap-table-develop/src/locale/bootstrap-table-zh-CN.js"></script>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <!-- 查询条件 -->
            <!--订单列表-->
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>列表详细信息管理 </h5>
                </div>
                <div class="ibox-content">
                    <div class="row row-lg">
                        <div class="col-sm-12">
                            <table id="bootstrapTable"></table>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    模态框（Modal）标题
                </h4>
            </div>
            <div class="modal-body">
                <div class = "1"></div>
                <div class = "1"></div>
                <div class = "1"></div>
                <div class = "1"></div>
                <div class = "1"></div>
                <div class = "1"></div>
                <div class = "1"></div>
                按下 ESC 按钮退出。

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>

    $("#myModa2").click(function(){
        $("#myModal").modal('toggle');
    });
    $("#bootstrapTable").bootstrapTable({
        url:'/freeMarker/tableDetailList.shtml?tableName=${tableName}',
        dataType:"json",
        striped:true, // 是否显示行间色
        striped:true, // 是否显示行间色
        paginationLoop:false, //分页是否循环
        sidePagination: "server", // 请求资源
        queryParams:{"tableName":"${tableName}"},
        columns:[
            {"field":"columnName", "title":"字段名"},
            {"field":"columnName", "title":"javaBean","formatter":function(value,row,index){
                return "<input type='text' class='form-control' readonly='readonly' value='"+javaBeanName(value)+"'>";
                }},
            {"field":"columnComment", "title":"注释", "formatter":function(value,row,index){
                    return "<input type='text' class='form-control' value='"+value+"'>";
                }},
            {"field":"operate", "title":"列表是否显示", "formatter":function(value,row,index){
                    return "<input type='checkbox' />"
                }},
            {"field":"operate", "title":"表单是否显示", "formatter":function(value,row,index){
                    return "<input type='checkbox' />"
                }},
            {"field":"operate", "title":"操作", "formatter":function(value,row,index){
                    var html = "<button class='btn btn-primary' data-toggle='modal' data-target='#myModal'>表单编辑</button>" +
                        "<button class='btn btn-primary'>筛选条件</button>"
                    return html;
                }
            },{
                "field":"operate",
                "title":"操作",
                "formatter":function(value,row,index){
                    return "<a href=''>详情</a>&nbsp;&nbsp;&nbsp;<a href=''>自动生成代码</a>"
                }
            },{
                "field":"operate",
                "title":"操作",
                "formatter":function(value,row,index){
                    return "<a href=''>详情</a>&nbsp;&nbsp;&nbsp;<a href=''>自动生成代码</a>"
                }
            },{
                "field":"operate",
                "title":"操作",
                "formatter":function(value,row,index){
                    return "<a href=''>详情</a>&nbsp;&nbsp;&nbsp;<a href=''>自动生成代码</a>"
                }
            }
        ]
    });

    var javaBeanName = function(value){
        var strs = value.split("_");
        var str="";
        if(strs.length>0){
            str += strs[0];
            for(var i=1;i<strs.length;i++){
                str += upperCase(strs[i]);
            }
        }else{
            str = value
        }
        return str;
    }

    var upperCase = function(str){
        if(str!=""||str!=null){
            return str.substring(0,1).toUpperCase()+str.substr(1,str.length);
        }
        return str;
    }
</script>
</body>
</html>
