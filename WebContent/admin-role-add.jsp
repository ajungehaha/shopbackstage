<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set value = "${pageContext.request.contextPath }" var="path"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<c:set value="${requestScope.authoritylist }" var="authoritylist"/>
<jsp:include page="_meta.jsp" />
<title>角色管理页面</title><!-- 更改相应的标题 -->
<meta charset="utf-8">
<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<!-- 填写需要的内容 -->
<article class="cl pd-20">
	<form action="${path }/Roleservlet?action=addOne" method="post" class="form form-horizontal" id="form-admin-role-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="roleName" name="roleName" datatype="*4-16" nullmsg="用户账户不能为空">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="roleDescribe" name="roleDescribe">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">网站权限：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<dl class="permission-list" name="">
					
					<dd>
						<dl class="cl permission-list2">
							<dd>
							<c:forEach items="${authoritylist }" var="authority">
								<label class="">
									<input type="checkbox" value="${authority.authorityID }" onclick="javascript:setvalue(this)" name="authorityID1" id="user-Character-0-0-0" class="authorityID1">
									${authority.authorityName }</label>
								</c:forEach>
								
									
							</dd>
						</dl>
						
					</dd>
				</dl>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input type="hidden" value="" name="authorityID"  id="authorityID" />
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<button type="submit" class="btn btn-success radius" id="admin-role-save" name="admin-role-save"><i class="icon-ok"></i> 确定</button>
			</div>
		</div>
	</form>
</article>

<jsp:include page="_footer.jsp"/>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
	function setvalue(obj)
	{
		
		var obj2 = document.getElementById("authorityID");
		console.log(obj);
		console.log(obj2);
		
		if(obj.checked==true)
			{
				obj2.setAttribute("value",obj.getAttribute("value"));
			}
			
	}
	
</script>
<script type="text/javascript">



</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>