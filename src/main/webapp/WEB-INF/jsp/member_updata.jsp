<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/resources/css/product_add.css" />
<script
	src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=request.getContextPath() %>/resources/js/product_add.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">

		</script>
</head>
<body>
	<div class="container">
		<div class="head">
			<a>首页</a>》 <span>会员管理</span>
		</div>
		<div class="nav">
			<ul>
				<li myAttr="goods">基本信息</li>
			</ul>
		</div>
		<div class="content">
			<form action="member/updata_member/${p.id }" method="post" enctype="multipart/form-data">
				<div class="table dl_border" myAttr="goods" style="display: block;">
					<dl>
						<dt>会员等级：</dt>
						<dd>
							<select name="member_garde" class="MemberId">
								<option value="青铜用户">青铜用户</option>
								<option value="白银用户">白银用户</option>
								<option value="黄金用户">黄金用户</option>
								<option value="铂金用户">铂金用户</option>
								<option value="钻石用户">钻石用户</option>
							</select>
						</dd>
					</dl>
					<dl>
						<dt>用户名：</dt>
						<dd>
							<input type="text" name="name" class="text" value="${p.name }" />
						</dd>
					</dl>
					<dl>
						<dt>Email：</dt>
						<dd>
							<input type="text" name="email" class="text" value="${p.email }" />
						</dd>
					</dl>
					<dl>
						<dt>昵称：</dt>
						<dd>
							<input type="text" name="nick_name" class="text" value="${p.nick_name }" />
						</dd>
					</dl>
					<dl>
						<dt>修改图片：</dt>
						<dd>
							<input type="file" name="file" class="" value="${p.img_url }" />
						</dd>
					</dl>
						<dt>&nbsp;</dt>
						<dd>
							<input type="submit" class="button" value="确 定"> <input
								type="reset" class="button" value="重 置">
						</dd>
					</dl>
				</div>
			</form>
			
			</div>
			
		</div>

	</div>
</body>
<script type="text/javascript">
		
			
	</script>
</html>
