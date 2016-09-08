			$(document).ready(function(){
				var lis=$(".nav li");		
				for(var i=0;i<lis.length;i++)
				{
					$(lis[i]).on("click",function(){
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
			
			//增加图片	
			function addImg(){
				$(".img_nav table tbody").append("<tr class='border'><td><input type='file' name='' class='product_img_file' value='' /></td><td><input type='text' name='' class='text' value='' /></td><td><input type='text' name='' class='text product_img_order' value='' /></td><td><a  class='delImg'>[删除]</a></td></tr>");
			}
			//删除图片增加的那一栏
			$(document).ready(function(){
				$(".delImg").live('click',function(){
					$(this).parents(".border").remove();
				})
			})
			//
			$(document).ready(function(){
				$(".param_btn").live('click',function(){
					$(".param_cont").append("<div class='param_list'><dl><dt>参数组：</dt><dd><input type='text' name='text' class='text' value='' /></dd><span><a class='param_list_del'>[删除]</a><a class='param_add'>[增加]</a></span></dl><dl><dd><input type='text' name='text' class='text param_text' value='' /></dd><dd><input type='text' name='text' class='text' value='' /></dd><span><a  class='param_del'>[删除]</a></span></dl></div>");
				})
			})
			$(document).ready(function(){
				$(".param_add").live('click',function(){
					$(".param_list").append("<dl><dd><input type='text' name='text' class='text param_text' value='' /></dd><dd><input type='text' name='text' class='text' value='' /></dd><span><a class='param_del'>[删除]</a></span></dl>");
				})
			})
			$(document).ready(function(){
				$(".param_del").live('click',function(){
					$(this).parents("dl").remove();
				})
			})
			
			//
			$(document).ready(function(){
				$(".param_list_del").live('click',function(){
					$(this).parents(".param_list").remove();
				})
			})