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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/product_param_add.css"/>
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
		
		<script type="text/javascript">

function addSelect(){
	$(".table").append("<dl><dt>&nbsp;</dt><dd><input type='text' name='text' class='text' value=''  /><span class='span_right'><a class='delParam'>删除</a></span></dd></dl>");
	
}
$(".delParam").live('click',function(){
					$(this).parents("dl").remove();
				})
		</script>
	</head>
	<body>
		<div class="container">
			<div class="head">
				<a>首页</a>》
				<span>商品管理</span>
			</div>
			
			<form action="" method="post" class="content">
				<div class="table dl_border" myAttr="goods" style="display: block;">
					<dl>
						<dt>绑定分类：</dt>
						<dd>
							<select name="productId" class="productId">
								<option value="">手机数码</option>
								<option value="">手机通讯</option>
								<option value="">&nbsp;手机数码</option>
								<option value="">&nbsp;&nbsp;手机</option>
								<option value="">&nbsp;&nbsp;对讲机</option>
							</select>
						</dd>
					</dl>
					
					<dl>
						<dt>名称：</dt>
						<dd>
							<input type="text" name="text" class="text" value="" />
						</dd>
					</dl>
					<dl>
						<dt>排序：</dt>
						<dd>
							<input type="text" name="text" class="text" value="" />
						</dd>
					</dl>
					<dl class="param_dl">
						<dt><input type="button" class="button" onclick="addSelect()" value="增加可选项" /></dt>
						<dd><span class="span_left">可选项</span><span class="span_right">操作</span></dd>
						
					</dl>
					<dl class="del">
						<dt>&nbsp;</dt>
						<dd>
							<input type="text" name="text" class="text" value=""  />
							<span class="span_right"><a class="delParam">删除</a></span>
						</dd>
					</dl>
					
				</div>	
				<dl>
						<dt>&nbsp;</dt>
						<dd>
							<input type="submit" class="button" value="确 定">
							<input type="button" class="button" value="返 回">
						</dd>
					</dl>
			</form>
			
		</div>
	</body>
	<script type="text/javascript">
		
			
	</script>
</html>
