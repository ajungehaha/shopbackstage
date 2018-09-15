<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set value = "${pageContext.request.contextPath }" var="path"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<jsp:include page="_meta.jsp" />
<c:set value="${requestScope.orderlist }" var="orderlist"></c:set>
<c:set value="${requestScope.productlist }" var="productlist"/>
<title>订单管理页面</title><!-- 更改相应的标题 -->
<meta charset="utf-8">
<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<!-- 填写需要的内容 -->
<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 订单管理 <span class="c-gray en">&gt;</span> 订单查询<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="text-c"> 
			<form action="${path}/Orderservlet?action=selectOrderAsorderID" method="post">
				<input type="text" class="input-text" style="width:250px" placeholder="输入订单编号" id="orderID" name="orderID">
				<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜订单</button>
				</form>
			</div>
			<div class="cl pd-5 bg-1 bk-gray mt-20"> </div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-hover table-bg table-sort">
					<thead>
						<tr class="text-c">
							
							<th width="60">ID</th>
							<th width="60">状态</th>
							<th width="60">金额</th>
							<th width="60">商品数量</th>
							<th width="80">用户名</th>
							<th width="80">派送地址</th>
							<th width="80">下单时间</th>
							<th width="80">支付时间</th>
							<th width="80">发货时间</th>
							<th width="80">交易成功时间</th>
							<th width="80">操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${orderlist }" var="order">
						<tr class="text-c">
							<td>${order.orderID}</td>
							<c:if test="${order.orderState==0}">
							<td>未支付</td>
							</c:if>
							<c:if test="${order.orderState==1}">
							<td>未发货</td>
							</c:if>
							<c:if test="${order.orderState==2}">
							<td>未收货</td>
							</c:if>
							<c:if test="${order.orderState==3}">
							<td>交易成功</td>
							</c:if>
							<c:if test="${order.orderState==4}">
							<td>未支付取消订单</td>
							</c:if>
							<c:if test="${order.orderState==5}">
							<td>退款中</td>
							</c:if>
							<c:if test="${order.orderState==6}">
							<td>退款成功</td>
							</c:if>
							<td>${order.orderPrice}</td>
							<td >${order.orderProductNum }</td>
							<td>${order.userName}</td>
							<td>${order.adressName }</td>
							<td>${order.placeTime}</td>
							<td>${order.payTime}</td>
							<td>${order.deliveryTime}</td>
							<td>${order.accessTime}</td>
							
							<td class="td-manage"><button onclick="javascript:show_product(${order.orderID})">查看详情</button>
							
								<c:if test="${order.orderState<2}">
								<button><a href="${path}/Orderservlet?action=fahuo&orderID=${order.orderID}">发货</a></button>
								</c:if>
								<c:if test="${order.orderState>0&&order.orderState<6 }">
								<button><a href="${path}/Orderservlet?action=tuikuan&orderID=${order.orderID}">退款</a></button>
								</c:if>
								<button><a href="order-changAdress.jsp?orderID=${order.orderID }">修改地址</a></button>
							</td>
						</tr>
						<div >
							<table class="table table-border table-bordered table-hover table-bg table-sort" id="${order.orderID }" style="display: none;">
								<thead>
									<tr class="text-c">
										
										<th width="200">商品ID</th>
										<th width="200">商品名称</th>
										<th width="200">订单价格</th>
										<th width="200">书号</th>
										<th width="200">出版社</th>			
										
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${productlist }" var="product">
									<tr class="text-c">
										<td>${product.productID }</td>
										<td>${product.productName }</td>
										<td>${product.productPrice }</td>
										<td>${product.bookNum }</td>
										<td>${product.press}</td>
										
									</tr>
								</c:forEach>
								</tbody>
							</div>
					</c:forEach>	
					</tbody>
				</table>
			</div>
		</article>
	</div>
</section>

<jsp:include page="_footer.jsp"/>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
var count=1;
function show_product(orderID){
	if(count%2==1)
		{
			document.getElementById(orderID).style.display='block';	
		}
	else{
		document.getElementById(orderID).style.display='none';	
	}
	count++;
} 

/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-停用*/
function member_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
		$(obj).remove();
		layer.msg('已停用!',{icon: 5,time:1000});
	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
		$(obj).remove();
		layer.msg('已启用!',{icon: 6,time:1000});
	});
}


</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>