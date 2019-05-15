<%@ page language="java" import="java.util.*" import="com.chen.lvyou.vo.ActionResponse" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>信息管理系统_用户登录</title>
    <link href="<%=basePath %>plugins/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath %>plugins/font-awesome.css" rel="stylesheet">
    <link href="<%=basePath %>plugins/bootstrap-dashen.css" rel="stylesheet">

</head>
<body>

<div id="btn">
    <a href="#" class="easyui-linkbutton">后台登录</a>
</div>

<div id="loginDialog" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title"><i class="fa fa-key"></i>&nbsp;后台系统登录</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" name="loginForm" id="loginForm" enctype="multipart/form-data"
                      method="post" class="mar_t15">

                    <div class="form-group">
                        <label for="userName" class="col-md-3 text-right">管理员名:</label>
                        <div class="col-md-9">
                            <input type="text" id="userName" name="userName" class="form-control" placeholder="请输入管理员名">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="col-md-3 text-right">密码:</label>
                        <div class="col-md-9">
                            <input type="password" id="password" name="password" class="form-control"
                                   placeholder="登录密码">
                        </div>
                    </div>

                </form>
                <style>#bookTypeAddForm .form-group {
                    margin-bottom: 10px;
                }  </style>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="exit()">关闭</button>
                <button type="button" class="btn btn-primary" onclick="ajaxLogin();">登录</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
    window.onload = function login() {
        $("#loginDialog input").val("");
        $('#loginDialog').modal('show');
    }

    function exit() {
        window.location.href = "<%=basePath%>mian";
    }

    function ajaxLogin() {
        $.ajax({
            url: "<%=basePath%>mainlogin",
            type: 'post',
            dataType: "json",
            data: {
                "username": $('#userName').val(),
                "password": $('#password').val()
            },
            success: function (obj) {
                // 参数为json类型的对象
                //var obj = eval('(' + data + ')');
                if (obj.body == "success") {
                    alert("登录成功！");
                    window.location.href = "<%=basePath%>main";
                } else {
                    alert(obj.body);
                }
            }
        });
    }


</script>
<script src="<%=basePath %>plugins/jquery.min.js"></script>
<script src="<%=basePath %>plugins/bootstrap.js"></script>
<script src="<%=basePath %>plugins/wow.min.js"></script>
<script src="<%=basePath %>js/index.js"></script>

</body>
</html>
</html>
