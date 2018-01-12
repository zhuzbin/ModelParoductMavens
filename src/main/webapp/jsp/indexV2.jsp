<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/6
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 数据表格</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="../img/favicon.ico">
    <link href="../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="../css/dataTables.bootstrap.css" rel="stylesheet">

    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/style.css?v=4.1.0" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="../css/jquery.dataTables_themeroller.css" />

    <!-- 全局js -->
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script src="../js/bootstrap.min.js?v=3.3.6"></script>

    <script src="../js/plugins/jeditable/jquery.jeditable.js"></script>

    <!-- Data Tables -->
    <script type="text/javascript" src="../js/jquery.dataTables.js"></script>
    <%--//<script src="../js/plugins/dataTables/jquery.dataTables.js"></script>--%>
    <script src="../js/dataTables.bootstrap4.js"></script>


    <!-- 自定义js -->
    <script src="../js/content.js?v=1.0.0"></script>

    <script type="text/javascript" src="../js/jquery.dataTables.min.js"></script>
    <title>Title</title>
</head>
<body>
<div class="wrapper wrapper-content animated fadeInRight">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>基本 <small>分类，查找</small></h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="table_data_tables.html#">选项1</a>
                            </li>
                            <li><a href="table_data_tables.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <table id="tables" class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th><input type="checkbox"></th>
                            <th>name</th>
                            <th>page</th>
                            <th>pageTotal</th>
                            <th>rows</th>
                            <th>rowsTotal</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
</div>
</body>
<script>
    $(document).ready(function(){
        $("#tables").DataTable({
            "lengthChange":false,
            "ordering": false,
            "searching": false,
            "serverSide": true,
            "ajax": {
                "url":"/getStuList"
            },
            "columns":[
                { data: "id", render:function (data,type,rowws,meta) {
                    return "<input type='checkbox' value='"+data+"'>"
                }},
                { data: "name" },
                { data: "page" },
                { data: "pageTotal" },
                { data: "rows" },
                { data: "rowsTotal" }
            ],
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }
        });
    });
</script>
</html>
