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
		
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/user.css"/>
		<script type="text/javascript">
        $(document).ready(function(){
	    $("#selectAll").on("click",function(){
		if($("#selectAll").attr("checked")=="checked")
		{
			$("[name='checkbox']").attr("checked",'true');//全选
		}
		else
		{
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
				<span>会员管理</span>
				<span>(共140条记录)</span>
			</div>
			<div class="list">
				<ul>
					<li class="list_add">
						<a href="member/add">添加</a>
					</li>
					<li><a href="javascript:" id="deleteBtn">删除</a></li>
					<li>刷新</li>
					<form action="member/list_name" method="POST" class="left">
					<select name="member_type" class="goods_select left" id="goods">
							<option value="会员等级">会员等级</option>
							<option value="青铜用户">青铜用户</option>
							<option value="白银用户">白银用户</option>
							<option value="黄金用户">黄金用户</option>
							<option value="铂金用户">铂金用户</option>
							<option value="钻石用户">钻石用户</option>
							
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
							<th ><a class="sort" name="name">用户名</a></th>
							<th ><a class="sort" name="productCategory">会员等级</a></th>
							<th ><a class="sort" name="price">Email</a></th>
							<th ><a class="sort" name="isMarketable">昵称</a></th>
							<th ><a class="sort" name="createDate">创建日期</a></th>
							<th><span>操作</span></th>
						</tr>
						<c:forEach items="${members }" var="member">
						<tr>
							<td class="check"><input type="checkbox"  name="checkbox" class="selectTag" id="ids" value="${member.id }" /></th>
							<td ><span>${member.name }</span></td>
							<td ><span>${member.member_garde}</span></td>
							<td ><span>${member.email}</span></td>
							<td ><span>${member.nick_name}</span></td>
							<td ><span>${member.create_date}</span></td>
							<td ><a href="member/updata/${member.id}">[编辑]</a><a href="member/show/${member.id}">[查看]</a></td>
						</tr>
						</c:forEach>
						
					</tbody>
				</table>
				<table class="page_table">
				<tr>
					<td colspan="6" align="center" >
						
						<a href="member/members.do?pageNo=${page.topPageNo}">
							<input type="button" name="fristPage" value="首页" />
						</a> 
						<c:choose>
							<c:when test="${page.pageNo!=1}">
								<a href="member/members.do?pageNo=${page.previousPageNo }">
									<input type="button" name="previousPage" value="上一页" />
								</a>
							</c:when>
							<c:otherwise>
								<input type="button" disabled="disabled" name="previousPage" value="上一页" />
							</c:otherwise>
						</c:choose>
						 <c:choose>
							<c:when test="${page.pageNo != page.totalPages}">
								<a href="member/members.do?pageNo=${page.nextPageNo }">
									<input type="button" name="nextPage" value="下一页" />
								</a>
							</c:when>
							<c:otherwise>
								<input type="button" disabled="disabled" name="nextPage" value="下一页" />
							</c:otherwise>
						</c:choose> 
						<a href="member/members.do?pageNo=${page.bottomPageNo}">
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
				url:'member/delete',
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
