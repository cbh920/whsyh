<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/resources/css/product_add.css" />
<script
	src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=request.getContextPath() %>/resources/js/product_add.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">

		</script>
</head>
<body>
	<div class="container">
		<div class="head">
			<a>首页</a>》 <span>订单管理</span>
		</div>
		<div class="nav">
			<ul>
				<li myAttr="goods">基本信息</li>
			</ul>
		</div>
		<div class="content">
			<div class="table dl_border" myAttr="goods" style="display: block;">
				
				<dl>
					<dt>编号：</dt>
					<dd>${show.coding }</dd>
				</dl>
				<dl>
					<dt>配送方式：</dt>
					<dd>${show.send_method }</dd>
				</dl>
				<dl>
					<dt>物流公司：</dt>
					<dd>${show.logistics }</dd>
				</dl>
				
				
				<dl>
					<dt>运货单：</dt>
					<dd>${show.waybill }</dd>
				</dl>
				<dl>
					<dt>收货人：</dt>
					<dd>${show.receiver }</dd>
				</dl>
				<dl>
					<dt>创建时间：</dt>
					<dd>${show.create_date }</dd>
				</dl>
				<dl>
					<dt>状态：</dt>
					<dd>${show.state }</dd>
				</dl>
				
				
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
		
			
</script>
</html>

