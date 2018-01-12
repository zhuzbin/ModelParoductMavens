<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/9/14
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.zhuzb.util.PropertiesConf" %>
<%
    request.setAttribute("productName",PropertiesConf.getParoductName());
%>
<html>
<head>
    <title>${productName}</title>
</head>
<body>
<%
    String path = request.getContextPath();
    System.out.println(path);
%>
</body>
</html>
