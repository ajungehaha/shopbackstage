<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set value = "${pageContext.request.contextPath }" var="path"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<jsp:include page="_meta.jsp" />
<c:set value="${sessionScope.classlist}" var="classlist"></c:set>
<c:set value="${requestScope.productlist}" var="productlist"></c:set>
<title>商品查询与修改页面</title><!-- 更改相应的标题 -->
<meta charset="utf-8">
<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<!-- 填写需要的内容 -->
<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>商品管理 <span class="c-gray en">&gt;</span> 商品查询 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="Hui-article">
		<div class="pos-a" style="width:100px;left:0;top:0; bottom:0; height:100%; border-right:1px solid #e5e5e5; background-color:#f5f5f5; font-size: 16px; margin: 0; float: none; padding-left:50px ; font-family: '微软雅黑';">
			<ul id="treeDemo" class="text-c" >
				<c:forEach items="${classlist}" var="classs">
					<li><a href="${path}/Productservlet?action=selectProductAsClass&classID=${classs['classID']}">${classs['className']}</a></li>
				</c:forEach>
			</ul>
		</div>
		<div style="margin-left:150px;">
			<div class="pd-20">
				<div class="text-c"> 
					  <form method = "post" action="${path}/Productservlet?action=selectOne">
					<input type="text" name="productName" id="" placeholder=" 产品名称" style="width:250px" class="input-text">
					<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜商品</button>
					</form>
				</div>
				<div class="cl pd-5 bg-1 bk-gray mt-20">  <a class="btn btn-primary radius" onclick="product_add('添加产品','${path}/Productservlet?action=productadd')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加商品</a></span>  </div>
				<div class="mt-20">
					<table class="table table-border table-bordered table-bg table-hover table-sort">
						<thead>
							<tr class="text-c">
								<th width="40px">ID</th>
								<th width="60px">缩略图</th>
								<th width="100px">商品名称</th>
								<th width="100px">出版社</th>
								<th width="80px">单价</th>
								<th width="150px">商品地址</th>
								<th width="80px">库存</th>
								<th width="80px">销量</th>
								<th width="80px">最低积分兑换</th>
								<th width="60px">状态</th>
								<th width="100px">操作</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${productlist}" var="product">
							<tr class="text-c va-m">
								<td>${product.productID }</td>
								<td><img style="width: 60px;"  src="${product.pictureAdress }"/></td>
								<td>${product.productName }</td>
								<td>${product.press }</td>
								<td><span class="price">${product.productPrice}</span> 元</td>
								<td>${product.productAdress }</td>
								<td>${product.productStock }</td>
								<td>${product.productSales }</td>
								<td>${product.lessIntegral }</td>
								<c:if test="${product.productState==1 }">
								<td class="td-status"><span class="label label-success radius">正在销售</span></td>
								<td class="td-manage"><a style="text-decoration:none" onClick="product_stop(this,'10001')" href="${path}/Productservlet?action=changeState&productState=0&productID=${product.productID}" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> <a style="text-decoration:none" class="ml-5" onClick="product_edit('产品编辑','${path}/Productservlet?action=productadd','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="product_del(this,'10001')" href="${path }/Productservlet?action=deleteProduct&productID=${product.productID}" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>							
								</c:if>
								<c:if test="${product.productState==0 }">
								<td class="td-status"><span class="label label-success radius">已下架</span></td>
								<td class="td-manage"><a style="text-decoration:none" onClick="product_get(this,'10001')" href="${path}/Productservlet?action=changeState&productState=1&productID=${product.productID}" title="上架"><i class="Hui-iconfont">&#xe6de;</i></a> <a style="text-decoration:none" class="ml-5" onClick="product_edit('产品编辑','${path}/Productservlet?action=productadd','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="product_del(this,'10001')" href="${path}/Productservlet?action=deleteProduct&productID=${product.productID}" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
								</c:if>								
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
</section>

<jsp:include page="_footer.jsp"/>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">
var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				demoIframe.attr("src",treeNode.file + ".html");
				return true;
			}
		}
	}
};
var zNodes =[
	{ id:1, pId:0, name:"一级分类", open:true},
	{ id:2, pId:1, name:"二级分类"},
	{ id:3, pId:2, name:"三级分类"},
	{ id:4, pId:3, name:"三级分类"},
	{ id:5, pId:4, name:"三级分类"},
	{ id:6, pId:5, name:"三级分类"},
	{ id:115, pId:11, name:"三级分类"},
	{ id:12, pId:1, name:"二级分类 1-2"},
	{ id:121, pId:12, name:"三级分类 1-2-1"},
	{ id:122, pId:12, name:"三级分类 1-2-2"},
];

var code;




$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  {"orderable":false,"aTargets":[0,7]}// 制定列不参与排序
	]
});

/*图片-下架*/
function product_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_get(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}
function product_get(obj,id){
	layer.confirm('确认要上架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="product_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已上架</span>');
		$(obj).remove();
		layer.msg('已上架!',{icon: 5,time:1000});
	});
}


/*图片-删除*/
function product_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}

function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
function product_edit(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url,
		id:id
	});
	layer.full(index);
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>