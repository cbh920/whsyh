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
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/homepage.css"/>
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath() %>/resources/js/homepage.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">

		</script>
	</head>
	<body>
		<div class="container">
			<table class="main">
				<tbody>
					<tr class="head">
						<th class="logo">
							<img src="img/logo.jpg"/>
						</th>
						<th>
							<div class="head_right">
								<div id="nav">
									<ul>
										<li><a id="nav0">åå</a></li>
										<li><a id="nav1">è®¢å</a></li>
										<li><a id="nav2">ä¼å</a></li>
										<li><a id="nav3">åå®¹</a></li>
										<li><a id="nav4">æé</a></li>
										<li><a id="nav5">ç»è®¡</a></li>
										<li><a id="nav6">ç³»ç»</a></li>
										<li><a id="nav7">é¦é¡µ</a></li>
									</ul>
								</div>
								<div class="link">
									<a href="">å®æ¹ç½ç«</a>&nbsp;|&nbsp;
									<a href="">äº¤æµè®ºå</a>&nbsp;|&nbsp;
									<a href="">å³äºæä»¬</a>
								</div>
								<div class="link">
									<strong>admin</strong>æ¨å¥½ï¼
									<a href="">[è´¦å·è®¾ç½®]</a>
									<a href="">[æ³¨é]</a>
								</div>
							</div>
						</th>
					</tr>
					<tr>
						<td class="menu">
							<dl class="product" style="display: block;"> 
								<dt><a>ååç®¡ç</a></dt>
								<dd><a class="good_manager">ååç®¡ç</a></dd>
								<dd><a class="stock_manager">åºå­ç®¡ç</a></dd>
								<dd><a href="#">åååæ°</a></dd>
								<dd><a href="#">åååç±»</a></dd>
								<dd><a href="#">ååå±æ§</a></dd>
								<dd><a href="#">è§æ ¼ç®¡ç</a></dd>
								<dd><a href="#">åçç®¡ç</a></dd>
								<dd><a href="#">å°è´§éç¥</a></dd>
							</dl>
							<dl class="order" style="display: none;"> 
								<dt><a href="#">è®¢åååç®¡ç</a></dt>
								<dd><a href="#">è®¢åç®¡ç</a></dd>
								<dd><a href="#">åè´§ç®¡ç</a></dd>
								<dd><a href="#">éè´§ç®¡ç</a></dd>
							</dl>
							<dl class="member" style="display: none;"> 
								<dt><a href="#">ä¼åç®¡ç</a></dt>
								<dd><a href="#">ä¼åç®¡ç</a></dd>
								<dd><a href="#">ä¼åç­çº§</a></dd>
								<dd><a href="#"></a></dd>
							</dl>
							<dl class="content" style="display: none;"> 
								<dt><a href="#">æç« åç±»</a></dt>
								<dd><a href="#">æç« åè¡¨</a></dd>
								<dd><a href="#">æç« èªå¨åå¸</a></dd>
								<dd><a href="#"></a></dd>
							</dl>
							<dl class="authorization" style="display: none;"> 
								<dt><a href="#">æéç®¡ç</a></dt>
								<dd><a href="#">ç®¡çååè¡¨</a></dd>
								<dd><a href="#">ç®¡çåæ¥å¿</a></dd>
								<dd><a href="#"></a></dd>
							</dl>
							<dl class="statistics" style="display: none;"> 
								<dt><a href="#">ç»è®¡æ¥è¡¨</a></dt>
								<dd><a href="#">å®¢æ·ç»è®¡</a></dd>
								<dd><a href="#">è®¢åç»è®¡</a></dd>
								<dd><a href="#">éå®æ¦åµ</a></dd>
								<dd><a href="#">éå®æç»</a></dd>
								<dd><a href="#">éå®æå</a></dd>
							</dl>
							<dl class="system" style="display: none;"> 
								<dt><a href="#">ç³»ç»ç®¡ç</a></dt>
								<dd><a href="#">ç³»ç»è®¾ç½®</a></dd>
								<dd><a href="#">å°åºåè¡¨</a></dd>
								<dd><a href="#"></a></dd>
							</dl>
						</td>
						<td class="menu_right">
							<iframe src="product.html" width="" height="" frameborder="0"></iframe>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</body>
</html>
