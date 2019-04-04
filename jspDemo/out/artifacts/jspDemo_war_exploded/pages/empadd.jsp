<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <TITLE>添加学生信息</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="/css/Manage2.css" type=text/css rel=stylesheet>
    <LINK href="/css/Manage.css" type=text/css rel=stylesheet>
    <%--引入日期选择插件--%>
    <script type="text/javascript" src="/My97DatePicker/WdatePicker.js"></script>

    <%--引入JQ--%>
    <script src="/js/jquery.min.js" type="text/javascript"></script>
    <%--消息--%>
    <script src="/js/messages_zh.js" type="text/javascript"></script>
    <%--引入校验框架--%>
    <script src="/js/jquery.validate.js" type="text/javascript"></script>

    <script type="text/javascript">
        loadDistrict();
        function loadDistrict() {
            $.ajax({
                url : "/districtListServlet",
                type : "get",
                dataType : "json",
                success : function(data) {
                    var dh = "<option value=''>---请选择---</option>";
                    for(var i=0;i<data.length;i++){
                        var selected = data[i].id==${district == null ? "''" : district}?"selected":"";
                        dh += "<option value='"+data[i].id+"'"+selected+">"+data[i].district+"</option>";
                    }
                    $("#district").html(dh);
                }
            });
        }
        loadLouDong();
        function loadLouDong() {
            $.ajax({
                url : "/districtListServlet?id=1",
                type : "get",
                dataType : "json",
                success : function(data) {
                    var dh = "<option value=''>---请选择---</option>";
                    for(var i=0;i<data.length;i++){
                        var selected = data[i].id==${loudong == null ? "''" : loudong}?"selected":"";
                        dh += "<option value='"+data[i].id+"'"+selected+">"+data[i].fid+"</option>";
                    }
                    $("#loudong").html(dh);
                }
            });
        }
        $(function(){
            // 对表单进行数据校验
            $("#form1").validate({
                // 表单提交句柄,为一回调函数，带一个参数：form
                submitHandler: function(form){
                    // 提交表单
                    form.submit();
                },
                rules:{
                    ename:{
                        required:true
                    },
                    age:{
                        required:true
                    },
                    sex:{
                        required:true
                    },
                    sal:{
                        required:true
                    },
                    birthday:{
                        required:true
                    },
                    edate:{
                        required:true
                    }
                },
                messages:{
                    ename:{
                        required:"不能为空"
                    },
                    age:{
                        required: "不能为空"
                    },
                    sex:{
                        required: "不能为空"
                    },
                    sal:{
                        required: "不能为空"
                    },
                    birthday:{
                        required: "不能为空"
                    },
                    edate:{
                        required: "不能为空"
                    }
                }
            });
        });

    </script>

</HEAD>
<BODY>

<FORM id=form1 name=form1 action="/empAddServlet" method=post>

    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
            <TR>
                <TD width=15>
                    <IMG src="/images/new_019.jpg" border=0>
                </TD>
                <TD width="100%" background="/images/new_020.jpg" height=20></TD>
                <TD width=15>
                    <IMG src="/images/new_021.jpg"border=0>
                </TD>
            </TR>
        </TBODY>
    </TABLE>

    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15 background=/images/new_022.jpg>
                <IMG src="/images/new_022.jpg" border=0>
            </TD>
            <TD vAlign=top width="100%" bgColor=#ffffff>
                <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
                    <TR>
                        <TD class=manageHead>当前位置：信息管理 &gt; 添加学生信息</TD>
                    </TR>
                    <TR>
                        <TD height=2></TD>
                    </TR>
                </TABLE>

                <TABLE cellSpacing=0 cellPadding=5  border=0>

                    <TR>
                        <td>学生名称</td>
                        <td>
                            <INPUT class=textbox  style="WIDTH: 180px" maxLength=50 name="ename">
                        </td>
                        <td>学生年龄</td>
                        <td>
                            <INPUT class=textbox style="WIDTH: 180px" maxLength=50 name="age">
                        </td>
                    </TR>

                    <TR>
                        <td>学生性别</td>
                        <td>
                            <input type="radio" name="sex" value="1" checked/>男
                            <input type="radio" name="sex" value="0"/>女
                        </td>
                        <td>学生学费</td>
                        <td>
                            <INPUT class=textbox  style="WIDTH: 180px" maxLength=50 name="sal">
                        </td>
                    </TR>

                    <TR>
                        <td>学生生日</td>
                        <td>
                            <INPUT class=textbox  style="WIDTH: 180px" maxLength=50 name="birthday" onclick="WdatePicker()" readonly>
                        </td>
                        <td>入校日期</td>
                        <td>
                            <INPUT class=textbox  style="WIDTH: 180px" maxLength=50 name="edate" onclick="WdatePicker()" readonly>
                        </td>
                    </TR>
                    <TR>
                        <td>学生籍贯</td>
                        <td>
                            <select class=textbox name="districtId" id="district" style="width: 180px;" >
                            </select>
                        </td>
                        <td></td>
                        <td></td>
                    </TR>
                    <TR>
                        <td>学生宿舍</td>
                        <td>
                            <select class=textbox name="loudongId" id="loudong" style="width: 180px;" >
                            </select>
                        </td>
                        <td></td>
                        <td></td>
                    </TR>
                    <tr>
                        <td rowspan=2>
                            <INPUT class="button" id="sButton2" type="submit" value="保存" name="sButton2"/>
                        </td>
                    </tr>
                </TABLE>

            </TD>
            <TD width=15 background="/images/new_023.jpg">
                <IMG src="/images/new_023.jpg" border=0>
            </TD>
        </TR>
        </TBODY>
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15>
                <IMG src="/images/new_024.jpg" border=0>
            </TD>
            <TD align=middle width="100%" background="/images/new_025.jpg" height=15></TD>
            <TD width=15>
                <IMG src="/images/new_026.jpg" border=0>
            </TD>
        </TR>
        </TBODY>
    </TABLE>
</FORM>
</BODY>
</HTML>