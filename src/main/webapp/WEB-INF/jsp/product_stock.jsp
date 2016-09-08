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
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/product_stock.css"/>
	</head>
	<body>
		<div class="container">
			<div class="head">
				<a>首页</a>》
				<span>库存记录</span>
				<span>(共40条记录)</span>
			</div>
			<div class="list">
				<ul>
					<li class="list_add">
						入库
					</li>
					<li>出库</li>
					<li>刷新</li>
					<select name="goods_page" class="goods_page">
							<option value="1">每页显示</option>
							<option value="2">10</option>
							<option value="2">20</option>
							<option value="3">50</option>
					</select>
					<input type="text" name="search_text" id="search_text" value="" />
					<input type="button" name="search" id="search" value="查找" />
				
				</ul>
				<table id="listTable" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							
							<th ><a class="sort" >编号</a></th>
							<th ><a class="sort" >商品</a></th>
							<th ><a class="sort" >类型</a></th>
							<th ><a class="sort" >入库数量</a></th>
							<th ><a class="sort" >出库数量</a></th>
							<th ><a class="sort" >出库数量</a></th>
							<th ><a class="sort" >出库数量</a></th>
							<th><span>操作</span></th>
						</tr>
						<tr>
							
							<td ><span>20150211</span></td>
							<td >
								<span title="索尼 KDL-50W700B">
									索尼 KDL-50W700B
								</span>
								<span class="promotion" title="平板电视促销专场">返券促销</span>
							</td>
							<td ><span>平板电视</span></td>
							<td ><span>￥4688.00</span></td>
							<td ><span>是</span></td>
							<td ><a>[编辑]</a><a>[查看]</a></td>
						</tr>
					</tbody>
				</table>
				
				
				
				
			</div>
		</div>
	</body>
</html>
