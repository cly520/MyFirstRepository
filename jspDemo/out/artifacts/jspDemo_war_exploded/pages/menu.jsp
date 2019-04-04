<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="/css/menu.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="all">
    <div id="menu">
        <ul>
            <%--判断该用户是否为管理员--%>
            <c:choose>
               <%--该用户不是管理员 则显示学生的操作界面--%>
                <c:when test="${user.nickname =='管理员'}">
            <li><img src="/images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="/empListServlet" target="main">信息管理</a></li>
            <li><img src="/images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="/baoXiuListServlet" target="main">维修管理</a></li>
            <li><img src="/images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="/louDongListServlet" target="main">楼栋管理</a></li>
                </c:when>
                <%--该用户是管理员则显示管理员的操作界面--%>
                <c:otherwise>
            <li><img src="/images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="/empListServlet" target="main">信息界面</a></li>
                    <li><img src="/images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="/baoXiuListServlet" target="main">维修报表</a></li>
                    <li><img src="/images/li.jpg" />&nbsp;&nbsp;&nbsp; <a href="/louDongListServlet" target="main">楼栋界面</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>
</body>
</html>
