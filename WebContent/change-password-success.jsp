<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<jsp:include page="_meta.jsp" />
<title>修改密码成功页面</title><!-- 更改相应的标题 -->
<meta charset="utf-8">
<% String path = request.getContextPath(); %>
<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<jsp:include page="_header.jsp"/>
<jsp:include page="_menu.jsp"/>
<!-- 填写需要的内容 -->
<article>
	<div style="display: block; padding-left:300px;  ">
		<font color="blue" size="8px">修改密码成功!</font>
		<span id="second">5</span>
  		<span >秒后回到主页</span>
  			<a class="btn btn-default radius size-L" href="javascript:back();">返回</a>



  
	</div>
</article>

<jsp:include page="_footer.jsp"/>
<script type="text/javascript">  
    var num=document.getElementById("second").innerHTML;
   //获取显示秒数的元素，通过定时器来更改秒数。

    function count()
    {
        num--;
        document.getElementById("second").innerHTML=num;
        if(num==0)
        {
            location.assign("<%=path%>/index.jsp");
        }
    }
    setInterval("count()",1000);
   //通过window的location和history对象来控制网页的跳转。
    function back()
    {
       window.history.back();
   }

 </script> 
		
</body>
</html>