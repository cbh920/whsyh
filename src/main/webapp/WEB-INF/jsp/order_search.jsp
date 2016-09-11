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
				<span>订单管理</span>
				<span>(共${page.totalRecords}条记录)</span>
			</div>
			<div class="list">
				<ul>
					<li class="list_add">
						<a href="product/add">添加</a>
						
					</li>
					<li><a href="javascript:" id="deleteBtn">删除</a></li>
					<li>刷新</li>
					<form action="order/list_name" method="post" class="left">
					<select name="goods_select" class="goods_select">
							<option value="付款方式">付款方式</option>
							<option value="货到付款">货到付款</option>
							<option value="在线支付">在线支付</option>
							
					</select>
					<select name="goods_page" class="goods_page">
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
							<th ><a class="sort" name="productCategory">订单金额</a></th>
							<th ><a class="sort" name="price">会员</a></th>
							<th ><a class="sort" name="isMarketable">收货人</a></th>
							<th ><a class="sort" name="createDate">支付方式</a></th>
							<th ><a class="sort" name="createDate">配送方式</a></th>
							<th ><a class="sort" name="createDate">状态</a></th>
							<th ><a class="sort" name="createDate">创建日期</a></th>
							<th><span>操作</span></th>
						</tr>
						<c:forEach items="${listname }" var="order">
						<tr>
							<td class="check"><input type="checkbox" myBox="checkbox" class="selectTag" name="ids" value="${order.id }" /></td>
							<td ><span>${order.coding }</span></td>
							<td ><span>${order.money}</span></td>
							<td ><span>${order.member}</span></td>
							<td ><span>${order.receiver}</span></td>
							<td ><span>${order.payment_method}</span></td>
							<td ><span>${order.send_method}</span></td>
							<td ><span>${order.state}</span></td>
							<td ><span>${order.create_date}</span></td>
							<td ><a href="order/updata/${order.id}">[编辑]</a><a>[查看]</a></td>
						</tr>
						</c:forEach>
						<input type="hidden" name="ids" />
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
				url:'order/delete',
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

