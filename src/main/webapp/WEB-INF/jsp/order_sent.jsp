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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/order1.css"/>
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">

$(document).ready(function(){
	$("#selectAll").on("click",function(){
		if($("#selectAll").attr("checked")=="checked"){
//			alert("a");
			$("[name='checkbox']").attr("checked",'true');//全选
		}else{
			$("[name='checkbox']").removeAttr("checked");//取消全选
		}
	})
})
		</script>
	</head>
	<body>
		<div class="container">
			<div class="head">
				<a>首页</a>》
				<span>发货单列表</span>
				<span>(共10条记录)</span>
			</div>
			<div class="list">
				<ul>
					<li class="list_add">
						删除
					</li>
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
							<th ><a class="sort" name="name">编号</a></th>
							<th ><a class="sort" name="productCategory">配送方式</a></th>
							<th ><a class="sort" name="price">物流公司</a></th>
							<th ><a class="sort" name="isMarketable">运单号</a></th>
							<th ><a class="sort" name="createDate">收货人</a></th>
							<th ><a class="sort" name="createDate">是否需要物流</a></th>
							<th ><a class="sort" name="createDate">创建日期</a></th>
							<th><span>操作</span></th>
						</tr>
						<tr>
							<td class="check"><input type="checkbox"  name="checkbox" id="ids" value="" /></th>
							<td ><span>11111111</span></td>
							<td >
								<span title="">
									快递
								</span>
								<span class="promotion" title=""></span>
							</td>
							<td ><span>申通快递</span></td>
							<td ><span>1111</span></td>
							<td ><span>cbh</span></td>
							<td ><span>是</span></td>
							<td ><span>2016-09-08</span></td>
							<td ><a>[编辑]</a><a>[查看]</a></td>
						</tr>
					</tbody>
				</table>
				
				
				
				
			</div>
		</div>
	</body>
</html>
