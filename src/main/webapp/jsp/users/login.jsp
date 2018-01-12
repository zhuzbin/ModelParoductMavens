<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/9/14
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../inclue/commion.jsp"></jsp:include>
<html>
<head>
    <title>${productName}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- CSS -->

    <link rel="stylesheet" href="../../css/supersized.css">
    <link rel="stylesheet" href="../../css/login.css">
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="../../js/jquery.form.js"></script>
    <script type="text/javascript" src="../../js/tooltips.js"></script>
    <script type="text/javascript" src="../../js/login.js"></script>

</head>
<body>

<div class="page-container">
    <div class="main_box">
        <div class="login_box">
            <div class="login_logo">
                <img src="../../img/logo.png" >
            </div>

            <div class="login_form">
                <form action="index.html" id="login_form" method="post">
                    <div class="form-group">
                        <label for="j_username" class="t">用户名：</label>
                        <input id="email" value="" name="email" type="text" class="form-control x319 in" placeholder="手机/邮箱/用户名" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <label for="j_password" class="t">密　码：</label>
                        <input id="password" value="" name="password" type="password"
                               class="password form-control x319 in">
                    </div>
                    <div class="form-group">
                        <label for="j_captcha" class="t">验证码：</label>
                        <input id="j_captcha" name="j_captcha" type="text" class="form-control x164 in">
                        <img id="captcha_img" alt="点击更换" title="点击更换" src="../../img/captcha.jpeg" class="m">
                    </div>
                    <div class="form-group">
                        <label class="t"></label>
                        <label for="j_remember" class="m">
                            <input id="j_remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label>
                    </div>
                    <div class="form-group space">
                        <label class="t"></label>　　　
                        <button type="button"  id="submit_btn"
                                class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp </button>
                        <input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
                    </div>
                </form>
            </div>
        </div>
        <div class="bottom">Copyright &copy; 2014 - 2015 <a href="#">系统登陆</a></div>
    </div>
</div>
<!-- Javascript -->

<script src="../../js/supersized.3.2.7.min.js"></script>
<script src="../../js/supersized-init.js"></script>
<script src="../../js/scripts.js"></script>
</body>
</html>
