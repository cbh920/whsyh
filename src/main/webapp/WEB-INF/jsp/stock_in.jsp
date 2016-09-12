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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/stock_in.css"/>
		<script
	src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js"
	type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div class="container">
			<div class="head">
				<a>首页</a>》
				<span>入库</span>
			</div>
			<form action="" method="post">
			<div class="content">
				<dl>
					<dt>商品选择:</dt>
					<dd><input type="text" name="search_text" id="search_btn" class="text" value="" /></dd>
				</dl>
				
				<div class="info" style="display:none;">
					<dl>
						<dt>编号:</dt>
						<dd>${stockLength}</dd>
					</dl>
					<dl>
						<dt>名称:</dt>
						<dd>${liststock.name} </dd>
					</dl>
					<dl>
						<dt>库存:</dt>
						<dd>${liststock.stock} </dd>
					</dl>
					
				</div>
				
				<dl>
					<dt>数量:</dt>
					<dd><input type="text" name="text" class="text" value="" /></dd>
				</dl>
				<dl>
					<dt>备注:</dt>
					<dd><input type="text" name="text" class="text" value="" /></dd>
				</dl>
				<dl>
					<dt>&nbsp;</dt>
					<dd>
						<input type="submit" class="button" value="确 定">
						<input type="button" id="aaa" class="button" value="返 回">
					</dd>
				</dl>
			</div>
			</form>
		</div>
	</body>
	<script>
	$(document).ready(function(){
	
	$("#search_btn").on("blur",function(){
		
		var text = $("#search_btn").val();
		$.ajax({
			url : 'product/stock_search',
			type : 'post',
			data : {
				text : text
			},
			 
			traditional : true,
			success : function(data) {
				
				alert("成功");
				$(".info").show();
				//window.location.reload();
				
			},
			error : function(data) {
				alert(data);
				alert("失败");
				
			}
		});
	});
	
	
	});
	
	</script>
	
</html>
