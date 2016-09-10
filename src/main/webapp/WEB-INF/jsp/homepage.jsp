<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/homepage.css"/>
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath() %>/resources/js/homepage.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">

		</script>
	</head>
	<body>
		<div class="container">
			<table class="main">
				<tbody>
					<tr class="head">
						<th class="logo">
							<img src="resources/img/logo.png" style="width: 100%;height: 100%;"/>
						</th>
						<th>
							<div class="head_right">
								<div id="nav">
									<ul>
										<li><a id="nav0">商品</a></li>
										<li><a id="nav1">订单</a></li>
										<li><a id="nav2">会员</a></li>
										<li><a id="nav3">内容</a></li>
										<li><a id="nav4">权限</a></li>
										<li><a id="nav5">统计</a></li>
										<li><a id="nav6">系统</a></li>
										<li><a id="nav7">首页</a></li>
									</ul>
								</div>
								<div class="link">
									<a href="">官方网站</a>&nbsp;|&nbsp;
									<a href="">交流论坛</a>&nbsp;|&nbsp;
									<a href="">关于我们</a>
								</div>
								<div class="link">
									<strong><c:out value="${user.name}" /> </strong>您好！
									<a href="">[账号设置]</a>
									<a href="">[注销]</a>
								</div>
							</div>
						</th>
					</tr>
					<tr>
						<td class="menu">
							<dl class="product" style="display: block;"> 
								<dt><a>商品管理</a></dt>
								<dd><a class="good_manager">商品管理</a></dd>
								<dd><a class="stock_manager">库存管理</a></dd>
								<dd><a href="product/add">商品参数</a></dd>
								<dd><a>商品分类</a></dd>
								<dd><a>商品属性</a></dd>
								<dd><a>规格管理</a></dd>
								<dd><a>品牌管理</a></dd>
								<dd><a>到货通知</a></dd>
							</dl>
							<dl class="order" style="display: none;"> 
								<dt><a>订单商品管理</a></dt>
								<dd><a>订单管理</a></dd>
								<dd><a>发货管理</a></dd>
								<dd><a>退货管理</a></dd>
							</dl>
							<dl class="member" style="display: none;"> 
								<dt><a>会员管理</a></dt>
								<dd><a>会员管理</a></dd>
								<dd><a>会员等级</a></dd>
							</dl>
							<dl class="content" style="display: none;"> 
								<dt><a>文章分类</a></dt>
								<dd><a>文章列表</a></dd>
								<dd><a>文章自动发布</a></dd>
							</dl>
							<dl class="authorization" style="display: none;"> 
								<dt><a>权限管理</a></dt>
								<dd><a>管理员列表</a></dd>
								<dd><a>管理员日志</a></dd>
								<dd><a></a></dd>
							</dl>
							<dl class="statistics" style="display: none;"> 
								<dt><a>统计报表</a></dt>
								<dd><a>客户统计</a></dd>
								<dd><a>订单统计</a></dd>
								<dd><a>销售概况</a></dd>
								<dd><a>销售明细</a></dd>
								<dd><a>销售排名</a></dd>
							</dl>
							<dl class="system" style="display: none;"> 
								<dt><a>系统管理</a></dt>
								<dd><a>系统设置</a></dd>
								<dd><a>地区列表</a></dd>
							</dl>
						</td>
						<td class="menu_right">
							<iframe src="product/products" width="" height="" frameborder="0"></iframe>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</body>
</html>
