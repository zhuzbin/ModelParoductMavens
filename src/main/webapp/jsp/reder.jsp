<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/1/8
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String paths = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.8.2.min.js"></script>
</head>
<body>
<c:forEach items="${list}" var="obj" varStatus="index">
    <div>方法名</div>
    <div id="div${index.index}">${obj.name}</div>
    <div>内容</div>
    <c:forEach items="${obj.obj}" var="obj1" varStatus="index2">
        <div id="div${index.index}${index2.index}"><div>${obj1}</div>&nbsp;&nbsp;&nbsp;<button id="id${index.index}${index2.index}" onclick="add('id${index.index}${index2.index}')">增加</button></div>
    </c:forEach>
</c:forEach>

<input type="button" value="提交" onclick="submit('1','11')" />
</body>
<script>
    function add(val){
        var str = "<div>System.out.println(5+5);</div>";
        $("#"+val).parent().append(str);
    }

    var path = '<%=paths%>';

    $(function(){

        //alert(path);
    })

    function retJson(idDiv){
        var array = new Array();
        $("#"+idDiv).find("div").each(function(){
           array.push($(this).text());
        });
        return JSON.stringify(array);
    }



    function submit(id,idDiv){
        var data = retJson("div"+idDiv);
        var name = $("#div"+id).text();
        alert(data+"===========>"+name);
        $.ajax({
            url:path+"/saveCal.shtml",
            data:{"data":data,"name":name},
            success:function(ret){
                alert(ret);
            }
        })
    }
</script>
</html>

