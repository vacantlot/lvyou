<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--footer-->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
            	<a href="#" target=_blank>© peanut的毕业设计</a> |
				<a href="#"></a> |
				<a href="#">联系我</a> |
				<a href="#">意见与建议</a> |
				<a href="#" target=_blank></a> |
				<a href="<%=basePath%>tologin">后台登录</a>
            </div>
        </div>
    </div>
</footer>
<!--footer--> 

 


 