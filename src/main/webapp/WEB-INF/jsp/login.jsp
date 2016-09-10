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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/login.css"/>
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
				var ok1=false;
				var ok2=false;
				//用户名不能为空
				$("input[name='name']").on("blur",function(){
					
					var name=$("input[name='name']").attr("value");
					if(name!=""){
						$(".name_span").html("");
						ok1=true;
					}else{
						$(".name_span").html("用户名不能为空！");
					}
				});
				//密码不能为空
				$("input[name='password']").on("blur",function(){
					
					var name=$("input[name='password']").attr("value");
					if(name!=""){
						$(".password_span").html("");
						ok2=true;
					}else{
						$(".password_span").html("密码不能为空！");
					}
				});
				//提交按钮,所有验证通过方可提交
                $('#login').click(function(){
                    if(ok1&&ok2){
                        $('form').submit();
                    }else{
                        return false;
                    }
                });
		})
	</script>
	<body>
		<div class="container">
			<div class="content">
				<div class="head">
					登入账号：
				</div>
				<form action="User/login_success" method="post">
					<dl>
						<dt>用户名：</dt>
						<dd>
							<input type="text" name="name" id="username" value="" />
						</dd>
						
					</dl>
					<div class="name_span" ></div>
					
					<dl>
						<dt>密码：</dt>
						<dd>
							<input type="text" name="password" id="password" value="" />
							
						</dd>
						
					</dl>
					<div class="password_span" ></div>
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
