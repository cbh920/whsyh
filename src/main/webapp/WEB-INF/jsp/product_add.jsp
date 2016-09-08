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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/product_add.css"/>
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath() %>/resources/js/product_add.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">

		</script>
	</head>
	<body>
		<div class="container">
			<div class="head">
				<a>首页</a>》
				<span>商品管理</span>
			</div>
			<div class="nav">
				<ul>
					<li myAttr="goods">基本信息</li>
					<li myAttr="introduce">商品介绍</li>
					<li myAttr="imgs">商品图片</li>
					<li myAttr="param">商品参数</li>
					<li myAttr="attr">商品属性</li>
				</ul>
			</div>
			<form action="" method="post" class="content">
				<div class="table dl_border" myAttr="goods" style="display: block;">
					<dl>
						<dt>商品分类：</dt>
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
						<dt>普通商品：</dt>
						<dd>
							<select name="" class="productId">
								<option value="">普通商品</option>
								<option value="">兑换商品</option>
								<option value="">赠品</option>
							
							</select>
						</dd>
					</dl>
					<dl>
						<dt>编号：</dt>
						<dd>
							<input type="text" name="text" class="text" value="" />
						</dd>
					</dl>
					<dl>
						<dt>名称：</dt>
						<dd>
							<input type="text" name="text" class="text" value="" />
						</dd>
					</dl>
					<dl>
						<dt>标题：</dt>
						<dd>
							<input type="text" name="text" class="text" value="" />
						</dd>
					</dl>
					<dl>
						<dt>销售价：</dt>
						<dd>
							<input type="text" name="text" class="text" value="" />
						</dd>
					</dl>
					<dl>
						<dt>图片：</dt>
						<dd>
							<input type="text" name="text" class="text" value="" />
						</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<input type="submit" class="button" value="确 定">
							<input type="button" class="button" value="返 回">
						</dd>
					</dl>
				</div>	
				<div class="table dl_border" myAttr="imgs" style="display: none;">
					<input type="button" class="button imgs_btn" value="增加图片" onclick="addImg(this)" />
					<div class="img_nav">
						<table >
							<tbody>
								<tr class="img_nav_top">
									<td>文件</td>
									<td>标题</td>
									<td>排序</td>
									<td>操作</td>
								</tr>
								<tr class="border">
									<td>
										<input type="file" name="" class="product_img_file" value="" />
									</td>
									<td>
										<input type="text" name="" class="text" value="" />
									</td>
									<td>
										<input type="text" name="" class="text product_img_order" value="" />
									</td>
									<td>
										<a class="delImg" >[删除]</a>
									</td>
								</tr>
								
							</tbody>
						</table>
						<dl>
							<dt>&nbsp;</dt>
							<dd>
								<input type="submit" class="button" value="确 定">
								<input type="button" class="button" value="返 回">
							</dd>
						</dl>
					
					</div>
				</div>	
				<div class="table dl_border param" myAttr="param" style="display: none;">
					<div class="param_cont">
						<input type="button" class="button param_btn" value="增加参数" onclick="addImg()" />
						<input type="button" class="button " value="重置参数" onclick="addImg()" />
						<div class="param_list">
							<dl>
								<dt>参数组：</dt>
								<dd><input type="text" name="text" class="text" value="" /></dd>
								<span><a class="param_list_del">[删除]</a><a class="param_add">[增加]</a></span>
							</dl>
							<dl>
								<dd><input type="text" name="text" class="text param_text" value="" /></dd>
								<dd><input type="text" name="text" class="text" value="" /></dd>
								<span><a class="param_del">[删除]</a></span>
							</dl>
						</div>
						
					</div>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<input type="submit" class="button" value="确 定">
							<input type="button" class="button" value="返 回">
						</dd>
					</dl>
				</div>
				<div class="table" myAttr="attr" style="display: none;">
					
				</div>
			</form>
			
		</div>
	</body>
	<script type="text/javascript">
		
			
	</script>
</html>
