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
		<head>
		<meta charset="UTF-8">
		<title></title>
		
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/user.css"/>
		<script type="text/javascript">
		
		</script>
	</head>
	<body>
					<div class="container">
			<div class="head">
				<a>首页</a>》
				<span>会员管理</span>
				<span>(共140条记录)</span>
			</div>
			<div class="list">
				<ul>
					<li class="list_add">
						<a href="user_add.html">添加</a>
					</li>
					<li>删除</li>
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
							<th class="check"><input type="checkbox" id="selectAll" value="" /></th>
							<th ><a class="sort" name="name">用户名</a></th>
							<th ><a class="sort" name="productCategory">会员等级</a></th>
							<th ><a class="sort" name="price">Enail</a></th>
							<th ><a class="sort" name="isMarketable">昵称</a></th>
							<th ><a class="sort" name="createDate">创建日期</a></th>
							<th><span>操作</span></th>
						</tr>
						<tr>
							<td class="check"><input type="checkbox" id="ids" value="" /></th>
							<td ><span>xiaobaixiaobai</span></td>
							<td ><span >VIP1</span></td>
							<td ><span>123456789@163.com</span></td>
							<td ><span>小白</span></td>
							<td ><span>2016.09.07</span></td>
							<td ><a>[编辑]</a><a>[查看]</a></td>
						</tr>
					</tbody>
				</table>
				
				
				
				
			</div>
		</div>
	</body>
</html>
