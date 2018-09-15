<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<jsp:include page="_meta.jsp" />
<title>登陆书籍网上商城管理系统</title><!-- 更改相应的标题 -->
<meta charset="utf-8">
<% String path  = request.getContextPath();%>
<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<!-- 填写需要的内容 -->
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
	<div id="loginform" class="loginBox">
		<form class="form form-horizontal" action="<%=path %>/Loginservlet?action=login" method="post">
			<div class="row cl">
				<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
				<div class="formControls col-xs-8">
					<input id="adminName" name="adminName" type="text" placeholder="账户" class="input-text size-L">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
				<div class="formControls col-xs-8">
					<input id="adminPassword" name="adminPassword" type="password" placeholder="密码" class="input-text size-L">
				</div>
			</div>
			<%
				if(request.getAttribute("flag")!=null)
				{
					String flag =(String)request.getAttribute("flag");
					if(flag.equals("error"))
					{%>
						<div class="row cl">
						<div class="formControls col-xs-8 col-xs-offset-3">
							<font size=10px color=red>用户名或者密码错误</font>
						</div>
					</div>
					<% }
				}
			%>
			
			<div class="row cl">
				<div class="formControls col-xs-8 col-xs-offset-3">
					<input name="submit" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
					<input name="reset" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
				</div>
			</div>
		</form>
	</div>
</div>
<div class="footer">网上商城后台管理系统登录</div>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script>
//var _hmt = _hmt || [];
//(function() {
 // var hm = document.createElement("script");
  //hm.src = "https://hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  //var s = document.getElementsByTagName("script")[0]; 
  //s.parentNode.insertBefore(hm, s);
//})();
</script>

<jsp:include page="_footer.jsp"/>
</body>
</html>