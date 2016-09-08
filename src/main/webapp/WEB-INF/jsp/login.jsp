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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/login.css"/>
	</head>
	<body>
		<div class="container">
			<div class="content">
				<div class="head">
					登入账号：
				</div>
				<form action="" method="post">
					<dl>
						<dt>用户名：</dt>
						<dd><input type="text" name="username" id="username" value="" /></dd>
					</dl>
					<dl>
						<dt>密码：</dt>
						<dd><input type="text" name="password" id="password" value="" /></dd>
					</dl>
					<input type="submit" name="login" id="login" value="登入" />
					
				</form>
				<div class="content_foot">
					<span id="foget">
						<a>忘记密码</a>
					</span>
				</div>
			</div>
		</div>
	</body>
</html>
