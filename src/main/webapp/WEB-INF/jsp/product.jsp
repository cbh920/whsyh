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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/product.css"/>
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath() %>/resources/js/product.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		</script>
	</head>
	<body>
		<div class="container">
			<div class="head">
				<a>首页</a>
				<span>商品管理</span>
				<span>(共 条记录)</span>
			</div>
			<div class="list">
				<ul>
					<li class="list_add">
						<a href="product/add">添加</a>
						
					</li>
					<li><a href="javascript:" id="deleteBtn">删除</a></li>
					<li>刷新</li>
					<form action="product/list_name" method="get" class="left">
					<select name="goods" class="goods_select left" id="goods">
							<option value="商品筛选">商品筛选</option>
							<option value="手机数码">手机数码</option>
							<option value="手机">手机</option>
							<option value="对讲机">对讲机</option>
							
					</select>
					<select name="goods_page" class="goods_page left">
							<option value="1">每页显示</option>
							<option value="2">10</option>
							<option value="2">20</option>
							<option value="3">50</option>
					</select>
					
						<input type="text" name="search_text" id="search_text" value="" />
						<input type="submit" name="search" id="search" value="查找" />
					</form>
				</ul>
				<table id="listTable" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<th class="check"><input type="checkbox" id="selectAll" value="" /></th>
							<th ><a class="sort" name="name">编号</a></th>
							<th ><a class="sort" name="product_name">名称</a></th>
							<th ><a class="sort" name="productCategory">商品分类</a></th>
							<th ><a class="sort" name="price">销售价</a></th>
							<th ><a class="sort" name="isMarketable">是否上架</a></th>
							<th ><a class="sort" name="createDate">创建日期</a></th>
							<th><span>操作</span></th>
						</tr>
						<c:forEach items="${datas }" var="product">
						<tr>
							<td class="check"><input type="checkbox" myBox="checkbox" class="selectTag" name="ids" value="${product.id }" /></td>
							<td ><span>${product.coding }</span></td>
							<td ><span>${product.name }</span></td>
							<td ><span>${product.product_type }</span></td>
							<td ><span>${product.sale_price }</span></td>
							<td ><span>${product.is_putaway }</span></td>
							<td ><span>${product.create_date }</span></td>
							<td ><a href="product/updata/${product.id}">[编辑]</a><a href="product/show/${product.id}">[查看]</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
	<script>
		function getSelect(){
			var selected = $(".selectTag:checked");
			var ids = new Array();
			for(var i=0;i<selected.length;i++){
				ids[i] = selected[i].value;
			}
			return ids;
		}
		$("#deleteBtn").click(function(){
			var ids = getSelect();
			$.ajax({
				url:'product/delete',
				type:'get',
				data:{ids:ids},
				traditional:true,
				success:function(data){
					alert("删除成功");
					window.location.reload();
				},
				error:function(data){
					alert("删除失败");
				}
			});
		});
		
	</script>
</html>
