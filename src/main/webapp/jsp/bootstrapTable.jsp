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
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>查询条件</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-1 control-label">普通</label>

                            <div class="col-sm-3">
                                <input type="text" class="form-control">
                            </div>
                            <label class="col-sm-1 control-label">普通</label>

                            <div class="col-sm-3">
                                <input type="text" class="form-control">
                            </div>
                            <label class="col-sm-1 control-label">普通</label>

                            <div class="col-sm-3">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">普通</label>

                            <div class="col-sm-3">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-6">
                                <button type="button" class="btn btn-outline btn-default pull-right" onclick="javascript:location.reload(true);"><i class="fa fa-reply"></i> 重置</button>
                            </div>
                            <div class="col-xs-6">
                                <button type="button" class="btn btn-primary pull-left" id="query_button"><i class="fa fa-search"></i> 查询</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- 查询条件 -->
            <!--订单列表-->
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>报单人员管理 </h5>
                </div>
                <div class="ibox-content">
                    <div class="row row-lg">
                        <div class="col-sm-12">
                            <div id="tools">
                                <button type="button" class="btn btn-primary" id="output_dbUser"  ><i class="fa fa-save"></i>&nbsp;增加数据</button>
                                <button type="button" class="btn btn-primary" id="output_dbUser"  ><i class="fa fa-paste"></i>&nbsp;修改数据</button>
                                <button type="button" class="btn btn-primary" id="output_dbUser"  ><i class="fa fa-trash-o"></i>&nbsp;批量删除数据</button>
                                <button type="button" class="btn btn-primary" id="output_dbUser"  ><i class="fa fa-file-excel-o"></i>&nbsp;导出数据</button>
                            </div>
                            <table id="bootstrapTable"></table>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>

<script>
    $("#bootstrapTable").bootstrapTable({
        url:"/freeMarker/tableList.shtml",
        dataType:"json",
        striped:true, // 是否显示行间色
        pagination:true, // 是否显示分页
        paginationLoop:false, //分页是否循环
        sidePagination: "server", // 请求资源
        pageSize :10, // 每页显示条数
        pageList:[1,5,10,50],
        toolbar:'#tools',
        toolbarAlign:'right',
        paginationPreText:'上一页',
        paginationNextText:'下一页',
        columns:[
            {
                "field":"state",<!-- 一定不要和返回的数据一样的名字 -->
                "checkbox": true
            },{
                "field":"tableName",
                "title":"表名"
            },{
                "field":"operate",
                "title":"操作",
                "formatter":function(value,row,index){
                    //alert(row.tableName);
                    return operation(row.tableName);
                }
            }
            ]
    });

    function operation(tableName){
        return '<a href="/tree/dataDetialTable.shtml?tableName='+tableName+'">详情</a>&nbsp;&nbsp;&nbsp;&nbsp;' +
            '<a href="/tree/dataDetialController.shtml?tableName='+tableName+'">操作controller</a>&nbsp;&nbsp;&nbsp;&nbsp;' +
            '<a href="/tree/dataDetialService.shtml?tableName='+tableName+'">操作service</a>&nbsp;&nbsp;&nbsp;&nbsp;' +
            '<a href="/tree/dataDetialDao.shtml?tableName='+tableName+'">操作dao</a>&nbsp;&nbsp;&nbsp;&nbsp;' +
            '<a href="/tree/dataDetialEntity.shtml?tableName='+tableName+'">操作entity</a>&nbsp;&nbsp;&nbsp;&nbsp;' +
            '&nbsp;&nbsp;&nbsp;&nbsp;';
    }
</script>
</body>
</html>
