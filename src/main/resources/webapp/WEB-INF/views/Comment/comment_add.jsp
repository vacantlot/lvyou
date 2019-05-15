<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%>
<jsp:include page="../check_logstate.jsp"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/comment.css" />
<div id="commentAddDiv">
	<form id="commentAddForm" enctype="multipart/form-data"  method="post">
		<div>
			<span class="label">被评景点:</span>
			<span class="inputControl">
				<input class="textbox" type="text" id="comment_scenicObj_scenicId" name="comment.scenicObj.scenicId" style="width: auto"/>
			</span>
		</div>
		<div>
			<span class="label">评论内容:</span>
			<span class="inputControl">
				<input class="textbox" type="text" id="comment_commentContent" name="comment.commentContent" style="width:200px" />

			</span>

		</div>
		<div>
			<span class="label">评论人:</span>
			<span class="inputControl">
				<input class="textbox" type="text" id="comment_userObj_user_name" name="comment.userObj.user_name" style="width: auto"/>
			</span>
		</div>
		<div>
			<span class="label">评论时间:</span>
			<span class="inputControl">
				<input class="textbox" type="text" id="comment_commentTime" name="comment.commentTime" style="width:200px" />

			</span>

		</div>
		<div class="operation">
			<a id="commentAddButton" class="easyui-linkbutton">添加</a>
			<a id="commentClearButton" class="easyui-linkbutton">重填</a>
		</div> 
	</form>
</div>
<script src="${pageContext.request.contextPath}/Comment/js/comment_add.js"></script> 
