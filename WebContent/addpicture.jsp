<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set value = "${pageContext.request.contextPath }" var="path"></c:set>
<html>
<head>
<jsp:include page="_meta.jsp" />
<title>添加商品图片页面</title><!-- 更改相应的标题 -->
<meta charset="utf-8">
<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
</head>
<body>

<!-- 填写需要的内容 -->
<div class="page-container">
	<form class="form form-horizontal" id="form-article-add" action="${path }/Productservlet?action=addOnepicture&productID=${requestScope.productID}" method="post" enctype="multipart/form-data" >
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">商品默认缩略图图片上传：</label>
			<div class="formControls col-xs-8 col-sm-9">
			<input type="file" name="picture" size="45"/>				
			</div>
		</div>
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="product_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
</div>

<jsp:include page="_footer.jsp"/>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript">

	
</script>





<!--
	作者：1757243947@qq.com
	时间：2018-08-29
	描述:自己写的javascript函数   用来进行提交的。
-->
<script></script>
</body>
</html>