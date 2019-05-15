<%--
  Created by IntelliJ IDEA.
  User: Chen
  Date: 2019/4/24
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>js弹框3秒后自动消失</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>plugins/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/demo.css"/>
</head>
<body>
<button onclick="showModal()">点击弹出模态框</button>

<div class='modal my-modal-alert' id='my-modal-alert'>
    <div class='modal-dialog boxBodySmall'>
        <div class='modal-content'>
            <div class='modal-header boxHeader'>
                <button type='button' class='close boxClose' data-dismiss='modal'>
                    <span aria-hidden='true'>&times;</span><span class='sr-only'>Close</span>
                </button>
                <h4 class='modal-title boxTitle' id='modal-title'>模态框</h4>
            </div>
            <div class='modal-body' id='modal-body-alert'>
                <div id='modal_message'>js弹框自动消失案例</div>
                <span id='num'></span>
            </div>
            <div class='modal-footer boxFooter' id='modal-footer'>
                <button type='button' class='btn btn-default boxButton' data-dismiss='modal'>关闭</button>
                <button type='button' class='btn btn-primary boxButton'>保存</button>
            </div>
        </div>
    </div>
</div>

<script src="<%=basePath %>js/jquery/jquery-1.11.3.js"></script>
<script src="<%=basePath %>plugins/bootstrap.min.js"></script>
<script src="<%=basePath %>plugins/jquery-ui.min.js"></script>

<script>
    var clearFlag = 0;
    var count = 3;//设置3秒后自动消失
    var showModal = function(){
        $("#my-modal-alert").toggle();//显示模态框

        $("#my-modal-alert").draggable({//设置模态框可拖动（需要引入jquery-ui.min.js）
            handle: ".modal-header"
        });

        clearFlag = self.setInterval("autoClose()",1000);//每过一秒调用一次autoClose方法
    }

    var autoClose = function(){
        if(count>0){
            $("#num").html(count + "秒后窗口将自动关闭");
            count--;
        }else if(count<=0){
            window.clearInterval(clearFlag);
            $("#num").html("");
            $("#my-modal-alert").fadeOut("slow");
            count = 3;
            $("#my-modal-alert").toggle();
        }
    }
</script>
</body>
</html>