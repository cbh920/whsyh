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
			<a>首页</a>》 <span>订单管理</span>
		</div>
		<div class="nav">
			<ul>
				<li myAttr="goods">基本信息</li>
			</ul>
		</div>
		<div class="content">
			<form action="order/updata_order/${o.id}" method="post">
				<div class="table dl_border" myAttr="goods" style="display: block;">
					
					<dl>
						<dt>编号：</dt>
						<dd>
							<input type="text" name="coding" class="text" value="${o.coding}" />
						</dd>
					</dl>
					<dl>
						<dt>订单金额：</dt>
						<dd>
							<input type="text" name="money" class="text" value="${o.money }" />
						</dd>
					</dl>
					<dl>
						<dt>会员：</dt>
						<dd>
							<input type="text" name="member" class="text" value="${o.member}" />
						</dd>
					</dl>
					<dl>
						<dt>收货人：</dt>
						<dd>
							<input type="text" name="receiver" class="text" value="${o.receiver}" />
						</dd>
					</dl>
					<dl>
						<dt>支付方式：</dt>
						<dd>
							<input type="text" name="payment_method" class="text" value="${o.payment_method }" />
						</dd>
					</dl>
					<dl>
						<dt>配送方式：</dt>
						<dd>
							<input type="text" name="send_method" class="text" value="${o.send_method }" />
						</dd>
					</dl>
					<dl>
						<dt>状态：</dt>
						<dd>
							<input type="text" name="state" class="text" value="${o.state }" />
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
</body>
<script type="text/javascript">
		
			
	</script>
</html>
