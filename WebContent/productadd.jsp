<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set value = "${pageContext.request.contextPath }" var="path"></c:set>
<html>
<head>
<jsp:include page="_meta.jsp" />
<title>添加商品页面</title><!-- 更改相应的标题 -->
<c:set value="${requestScope.classlist }" var="classlist"></c:set>
<meta charset="utf-8">
<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
</head>
<body>

<!-- 填写需要的内容 -->
<div class="page-container">
	<form class="form form-horizontal" id="form-article-add" action="${path }/Productservlet?action=addOne" method="post"  >
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">商品名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="productName" name="productName"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>分类栏目：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
				<select name="className" class="select">
				<c:forEach items="${classlist }" var = "classs">
					<option value="${classs['className'] }">${classs['className'] }</option>
					
					</c:forEach>
				</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">销售价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="productPrice" name="productPrice"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">商品成本价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="productCsot" name="productCsot"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">库存量：</label>
			<div class="formControls col-xs-8 col-sm-9 ">				
				<input type="text" class="input-text"  placeholder="" id="productStock" name="productStock"/>				
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">商品地址：</label>
			<div class="formControls col-xs-8 col-sm-9 ">				
				<input type="text" class="input-text" value="" placeholder="" id="productAddress" name="productAddress"/>				
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">出版社：</label>
			<div class="formControls col-xs-8 col-sm-9 ">				
				<input type="text" class="input-text" value=""  placeholder="" id="Press" name="Press"/>				
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>出版日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" name="pressTime"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">书号：</label>
			<div class="formControls col-xs-8 col-sm-9 ">				
				<input type="text" class="input-text" value="" placeholder="" id="bookNum" name="bookNum"/>				
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>印刷日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d'})" id="logmax" class="input-text Wdate" name="printingTime"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">书籍作者：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="authorName" name="authorName"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">购买的最低积分兑换数量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="lessIntegral" name="lessIntegral"/>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">商品详情摘要：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="productCast" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="textarealength(this,200)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
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

!--请在下方写此页面业务相关的脚本-->
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