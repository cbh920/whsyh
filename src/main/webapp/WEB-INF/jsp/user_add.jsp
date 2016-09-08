<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style class="css">
.nav li{width:500px;height:30px;margin:0px auto;background:#ddd;}
.nav li{display:block;width:80px;height:30px;line-height:30px;text-align:center;font-size:14px;float:left;color:#000;text-decoration:none;}
.nav li:hover{background:#fff;text-decoration:none;}
.nav li.cc{color:red;background:#fff;}
		</style>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/user_add.css"/>
		<script src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				var lis=$(".nav li");
//				alert(lis.length);
				
				for(var i=0;i<lis.length;i++)
				{
					$(lis[i]).on("click",function(){
//						alert(lis.length);
						var lis_attr=$(this).attr("myAttr"); 
						var table_lis=$(".table");
						for(var j=0;j<table_lis.length;j++)
						{
							var table_attr=$(table_lis[j]).attr("myAttr");
							if(lis_attr==table_attr)
							{
								$(table_lis[j]).show();
							}else{
								$(table_lis[j]).hide();
							}
							
						}
					})
				}
			})
		</script>
	
<script type="text/javascript">
	function dangqian(id)
	{
		for(i=1;i<3;i++)
		{
			if(i==id)
			{
				document.getElementById(i).className='cc';
			}
			else
			{
				document.getElementById(i).className='';
			}
			
		}
	}
</script>

	</head>
	<body>
		<div class="container">
			<div class="head">
				<a>首页</a>》
				<span>添加会员</span>
			</div>
			<div class="nav">
				<ul >
					<li href="#" onclick="dangqian(this.id)" id="1" myAttr="usermess">基本信息</li>
					<li href="#" onclick="dangqian(this.id)" id="2" myAttr="perdata" >个人资料</li>

				</ul>
			</div>
			<form action="" method="post" class="content">
			<div class="table" myAttr="usermess" style="display: none;">
				<dl>
					<dt>用户名：</dt>
					<dd>
						<input type="text" name="text" class="text" value="" />
					</dd>
				</dl>
				<dl>
					<dt>密码：</dt>
					<dd>
						<input type="text" name="text" class="text" value="" />
					</dd>
				</dl>
				<dl>
					<dt>确认密码：</dt>
					<dd>
						<input type="text" name="text" class="text" value="" />
					</dd>
				</dl>
				<dl>
					<dt>E-mail：</dt>
					<dd>
						<input type="text" name="text" class="text" value="" />
					</dd>
				</dl>
				<dl>
					<dt>昵称：</dt>
					<dd>
						<input type="text" name="text" class="text" value="" />
					</dd>
				</dl>
				<dl>
					<dt>用户等级：</dt>
					<dd>
						<select name="userlv" class="userlv">
							<option value="">普通用户</option>
							<option value="">铜牌用户</option>
							<option value="">银牌用户</option>
							<option value="">金牌用户</option>
							
						</select>
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
				<div class="table" myAttr="perdata" style="display: block;">
					
					<div class="img_nav">
														<dl>
					<dt>姓名：</dt>
					<dd>
						<input type="text" name="text" class="text" value="" />
					</dd>
				</dl>
				<dl>
					<dt>年龄：</dt>
					<dd>
						<input type="text" name="text" class="text" value="" />
					</dd>
				</dl>
				<dl>
					<dt>性别：</dt>
					<dd>
						<input id="man" type="radio" checked="checked" name="1" />男
				<input id="woman" type="radio"  name="1"/>女
					</dd>
				</dl>
				<dl>
					<dt>手机号：</dt>
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
						
					</div>
					
				</div>	
			</form>

		</div>
	</body>
</html>
