<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--静态包含，引入系统页面--%>
<%@ include file="pages/base.jsp"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>用户登录</title>
    <link href="css/login.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript">
        // 页面加载
        $(function(){
            // 编写校验
            $("#loginForm").validate({
                // 表单提交句柄,为一回调函数，带一个参数：form
                submitHandler: function(form){
                    // 提交表单
                    form.submit();
                },
                rules:{
                    username:{
                        required:true
                    },
                    password:{
                        required:true,
                        rangelength:[3,10]
                    }
                },
                messages:{
                    username:{
                        required:"不能为空"
                    },
                    password:{
                        required: "不能为空",
                        rangelength: "密码长度3到10位"
                    }
                }
            });
        });
    </script>

</head>
<body background="images/bg.jpg">

<%--用户登录页面--%>
<form action="/userLoginServlet" method="post" id="loginForm">
    <div id="login" >
        <div id="top">
            <div id="top_left"><img src="images/login_03.gif" /></div>
            <div id="top_center"></div>
        </div>

        <div id="center">
            <div id="center_left"></div>
            <div id="center_middle">

                <div style="height: 16px;text-align: center">
                    <font color="red">${ errorMsg }</font>
                </div>

                <div style="height: 16px;text-align: center">
                    <font color="red">${ successMsg }</font>
                </div>

                <div id="user"><label for="username">用 户 名</label>
                    <input type="text" name="username" id="username"/>
                </div>
                <div id="password"><label for="pass">密   码</label>
                    <input type="password" name="password" id="pass"/>
                </div>
                <div id="btn">
                    <input type="submit" value="登录" />
                    <a href="register.jsp">注册</a>
                    <%--<a href="#">登录</a>
                    <a href="#">清空</a>--%>
                </div>

            </div>

            <div id="center_right"></div>
        </div>
        <div id="down">
            <div id="down_left">
                <div id="inf">
                    <span class="inf_text">版本信息</span>
                    <span class="copyright">宿舍管理系统 v1.0</span>
                </div>
            </div>
            <div id="down_center"></div>
        </div>

    </div>
</form>
</body>
</html>
