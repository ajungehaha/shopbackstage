<%@page import="com.shopbackstage.domain.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<jsp:include page="_meta.jsp" />
<title>修改密码页面</title><!-- 更改相应的标题 -->
<meta charset="utf-8">
<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<% String path = request.getContextPath();
	String adminName =(String) session.getAttribute("adminName");%>
<article class="cl pd-20">
	<form action="<%=path %>/Loginservlet?action=change" method="post" class="form form-horizontal" id="form-change-password">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>账户：</label>
			<div class="formControls col-xs-8 col-sm-9"> <%=adminName %> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="password" class="input-text" autocomplete="off" placeholder="不修改请留空" name="newpassword" id="newpassword">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>确认密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				
				<input type="password" class="input-text"  autocomplete="off" placeholder="不修改请留空" name="newpassword2" id="new-password2">
				<div id="cuowu" style="display: none;"><font color='red'>密码不一致</font></div>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" onsubmit='bijiao()' value="&nbsp;&nbsp;保存&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>
<!-- 填写需要的内容 -->


<jsp:include page="_footer.jsp"/>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
	function bijiao() {
		if($('#newpassword').val()!=$('#newpassword2').val())
		{
			$('#cuowu').style.display='block';
		}
		
	}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>