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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/stock_in.css"/>
	</head>
	<body>
		<div class="container">
			<div class="head">
				<a>首页</a>》
				<span>入库</span>
			</div>
			<div class="content">
				<dl>
					<dt>商品选择:</dt>
					<dd><input type="text" name="text" class="text" value="" /></dd>
				</dl>
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
						<input type="button" class="button" value="返 回">
					</dd>
				</dl>
			</div>
		</div>
	</body>
</html>
