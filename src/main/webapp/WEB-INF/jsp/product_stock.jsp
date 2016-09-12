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
		<base href="<%=basePath%>">
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
						<a href="product/stock_ins">入库</a>
					</li>
					<li>
						<a href="product/stock_out">出库</a>	
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
							
							<th ><a class="sort" >编号</a></th>
							<th ><a class="sort" >商品</a></th>
							<th ><a class="sort" >类型</a></th>
							<th ><a class="sort" >当前库存</a></th>
							<th ><a class="sort" >入库数量</a></th>
							<th ><a class="sort" >出库数量</a></th>
							<th ><a class="sort" >创建日期</a></th>
							
						</tr>
						<c:forEach items="${stock }" var="product">
							<tr>
								
								<td><span>${product.coding }</span></td>
								<td><span>${product.name }</span></td>
								<td><span>${product.product_type }</span></td>
								<td><span>${product.stock }</span></td>
								<td><span>${product.stock_in }</span></td>
								<td><span>${product.stock_out }</span></td>
								<td><span>${product.create_date }</span></td>
								
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
				<table class="page_table">
				<tr>
					<td colspan="6" align="center" >
						
						<a href="product/stock?pageNo=${page.topPageNo}">
							<input type="button" name="fristPage" value="首页" />
						</a> 
						<c:choose>
							<c:when test="${page.pageNo!=1}">
								<a href="product/stock?pageNo=${page.previousPageNo }">
									<input type="button" name="previousPage" value="上一页" />
								</a>
							</c:when>
							<c:otherwise>
								<input type="button" disabled="disabled" name="previousPage" value="上一页" />
							</c:otherwise>
						</c:choose>
						 <c:choose>
							<c:when test="${page.pageNo != page.totalPages}">
								<a href="product/stock?pageNo=${page.nextPageNo }">
									<input type="button" name="nextPage" value="下一页" />
								</a>
							</c:when>
							<c:otherwise>
								<input type="button" disabled="disabled" name="nextPage" value="下一页" />
							</c:otherwise>
						</c:choose> 
						<a href="product/stock?pageNo=${page.bottomPageNo}">
							<input type="button" name="lastPage" value="尾页" />
						</a>
						<div style="float:left; margin-left:-405px;margin-top:-46px;font-size:14px;color:#CDC673;width:150px;font-family:'微软雅黑';"><span><br> 当前第  <span style="color:blue;">[${page.pageNo}]</span> 页   | 共  <span style="color:blue;">[${page.totalPages}]</span> 页 </span></div>
					</td>
				</tr>
			</table>
				
				
				
			</div>
		</div>
	</body>
</html>
