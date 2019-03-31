<%--
  Created by IntelliJ IDEA.
  User: 龙吟
  Date: 2019-03-16
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--静态包含，引入系统页面--%>
<%@ include file="pages/base.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>学生用户注册界面</title>
    <link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<script type="text/javascript">
    // 页面加载
    $(function(){
        // 编写校验
        $("#registerForm").validate({
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
<form method="post" action="/userRegisterServlet" id="registerForm">
    <div id="login" >
        <div id="top">
            <div id="top_left"><h1>用户注册</h1></div>
        </div>

        <div id="center">
            <div id="center_left"></div>
            <div id="center_middle">

                <div style="height: 16px;text-align: center">
                    <font color="red">${ errorMsg }</font>
                </div>

                <div id="user"><label for="username">用 户 名</label>
                    <input type="text" name="username" id="username"/>
                </div>
                <div id="password"><label for="pass">密   码</label>
                    <input type="password" name="password" id="pass" />
                </div>
                <div id="btn">
                    <input type="submit" value="注册" />
                    <input type="reset"  value="重置" />
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
