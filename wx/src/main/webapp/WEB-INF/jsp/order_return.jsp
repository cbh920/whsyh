<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName

()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
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
				<span>退货单列表</span>
				<span>(共${page.totalRecords}条记录)</span>
			</div>
			<div class="list">
				<ul>
					
					<li><a href="javascript:" id="deleteBtn">删除</a></li>
					<li>刷新</li>
					<form id="mainForm" action="order/return" method="POST" class="left">
				     <select name="page_size" onchange="changePage()" id="pages" class="goods_page left">
							<option value="1">每页显示</option>
							<option value="10">10</option>
							<option value="20">20</option>
							<option value="50">50</option>
					</select>
					</form>
					<form action="order/list_name2" method="post" class="left">
					<input type="text" name="search_text" id="search_text" value="" />
					<input type="submit" name="search" id="search" value="查找" />
					</form>
				
				</ul>
				<table id="listTable" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<th class="check"><input type="checkbox" id="selectAll" value="" /></th>
							<th ><a class="sort" name="name">编号</a></th>
							<th ><a class="sort" name="productCategory">配送方式</a></th>
							<th ><a class="sort" name="price">物流公司</a></th>
							<th ><a class="sort" name="isMarketable">运单号</a></th>
							<th ><a class="sort" name="createDate">发货人</a></th>
							<th ><a class="sort" name="createDate">创建日期</a></th>
							<th><span>操作</span></th>
						</tr>
						<c:forEach items="${return1 }" var="order">
						<tr>
							<td class="check"><input type="checkbox"  name="checkbox"  class="selectTag" id="ids" value="${order.id}" /></th>
							<td ><span>${order.coding }</span></td>
							<td ><span>${order.send_method}</span></td>
							<td ><span>${order.logistics}</span></td>
							<td ><span>${order.waybill}</span></td>
							<td ><span>${order.receiver}</span></td>
							<td ><span>${order.create_date}</span></td>
							<td ><a href="order/updata2/${order.id}">[编辑]</a><a
								href="order/show2/${order.id}">[查看]</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<table class="page_table">
				<tr>
					<td colspan="6" align="center" >
						
						<a href="order.return?pageNo=${page.topPageNo}">
							<input type="button" name="fristPage" value="首页" />
						</a> 
						<c:choose>
							<c:when test="${page.pageNo!=1}">
								<a href="order/return?pageNo=${page.previousPageNo }">
									<input type="button" name="previousPage" value="上一页" />
								</a>
							</c:when>
							<c:otherwise>
								<input type="button" disabled="disabled" name="previousPage" value="上一页" />
							</c:otherwise>
						</c:choose>
						 <c:choose>
							<c:when test="${page.pageNo != page.totalPages}">
								<a href="order/return?pageNo=${page.nextPageNo }">
									<input type="button" name="nextPage" value="下一页" />
								</a>
							</c:when>
							<c:otherwise>
								<input type="button" disabled="disabled" name="nextPage" value="下一页" />
							</c:otherwise>
						</c:choose> 
						<a href="order/return?pageNo=${page.bottomPageNo}">
							<input type="button" name="lastPage" value="尾页" />
						</a>
						<span><br> 当前第  <span style="color:blue;">[${page.pageNo}]</span> 页     共  <span style="color:blue;">[${page.totalPages}]</span> 页 </span>
					</td>
				</tr>
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
				url:'order/delete2',
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
		function changePage()
	{
		$("#mainForm").submit();
	}
	</script>
</html>