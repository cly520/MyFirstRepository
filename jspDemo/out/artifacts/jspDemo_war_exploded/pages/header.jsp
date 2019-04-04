<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Admin Header</title>
    <link href="/css/header.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" language="javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript">
        var oplist = new Array('about', 'user', 'news', 'mars', 'jielong', 'box', 'school', 'config', 'other');
        $(document).ready(function() {
            $('#nav').find("a").click(function() {
                var id = $(this).attr('id');
                $.each(oplist, function(i, n) {
                    $('#'+n).attr('class', 'inactive');
                });
                $(this).parents("li").attr('class', 'active');
            });
        });
    </script>
</head>

<body>
<div id="all">
    <div id="banner"><h1 align="center">宿舍管理系统</h1></div>
    <div id="nav">
        <ul>
            <li class="inactive" id="other"><a href="#">按钮没用</a></li>
            <li class="inactive" id="about"><a href="#">无效按钮</a></li>
            <li class="inactive" id="user"><a href="#">只为好看</a></li>
        </ul>
    </div>
    <div id="main">
        <div id="welcome">
            <c:choose>
                <c:when test="${user.nickname == '管理员'}">
            尊敬的${user.nickname}欢迎您！！
            <%--<img src="/images/clock.gif" />--%>
                </c:when>
                <c:otherwise>
                    亲爱的${user.nickname}同学欢迎您！！
                    <%--<img src="/images/clock.gif" />--%>
                </c:otherwise>
            </c:choose>
        </div>
        <div id="adminop">
            <ul>
                <li><a href="/userExistServlet" target="_parent">用户退出</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
