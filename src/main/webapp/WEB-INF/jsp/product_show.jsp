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
			<a>首页</a>》 <span>商品管理</span>
		</div>
		<div class="nav">
			<ul>
				<li myAttr="goods">基本信息</li>
			</ul>
		</div>
		<div class="content">
			<div class="table dl_border" myAttr="goods" style="display: block;">
				<dl>
					<dt>商品分类：</dt>
					<dd>${show.product_type }</dd>
				</dl>
				<dl>
					<dt>编号：</dt>
					<dd>${show.coding }</dd>
				</dl>
				<dl>
					<dt>名称：</dt>
					<dd>${show.name }</dd>
				</dl>
				<dl>
					<dt>销售价：</dt>
					<dd>${show.sale_price }</dd>
				</dl>
				<dl>
					<dt>创建时间：</dt>
					<dd>${show.create_date }</dd>
				</dl>
				<dl style="height:200px;">
					<dt>图片预览：</dt>
					<dd><img alt="" src="${show.img_url }" style="width:200px;height:200px" /></dd>
				</dl>
				<dl>
					<dt>是否上架：</dt>
					<dd>${show.is_putaway }</dd>
				</dl>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
		
			
</script>
</html>
