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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/product.css"/>
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath() %>/resources/js/product.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			
		</script>
	</head>
	<body>
		<div class="container">
			<div class="head">
				<a>首页</a>》
				<span>属性列表</span>
				<span>(共25条记录)</span>
			</div>
			<div class="list">
				<ul>
					<li class="list_add">
						<a href="product_param_add.html">添加</a>
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
							<th class="check "><input type="checkbox" name="all_select" id="selectAll" value="" /></th>
							<th ><a class="sort" >名称</a></th>
							<th ><a class="sort" >绑定分类</a></th>
							<th ><a class="sort" >可选项</a></th>
							<th ><a class="sort" >排序</a></th>
							<th><span>操作</span></th>
						</tr>
						<tr>
							<td class="check" ><input type="checkbox" name="checkbox" id="ids" value="" /></th>
							<td ><span>屏幕尺寸</span></td>
							
							<td ><span>手机</span></td>
							<td ><span>3英寸以下 3-4英寸 4-5英寸 5-6英寸 6-7英寸 7-8英寸 8英寸以上 ...</span></td>
							<td ><span>1</span></td>
							<td ><a>[编辑]</a><a>[查看]</a></td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>
