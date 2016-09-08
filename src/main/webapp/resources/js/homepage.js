$(document).ready(function(){
				var cl=$("#nav li a");
				for(var c=0;c<cl.length;c++){	
					$(cl[c]).on("click", function(){
						var navId=this.id.charAt(3);
						var lis=$(".menu dl");
						for(var i=0;i<lis.length;i++)
						{
							if(i==navId){
								$(lis[i]).show();
							}
							else{
								$(lis[i]).hide();
							}
						}
					})
				}
			})

$(document).ready(function(){
	$(".good_manager").live("click",function(){
		$(".menu_right").html("<iframe src='product.html' width='' height='' frameborder='0'></iframe>");
	});
})

$(document).ready(function(){
	$(".stock_manager").live("click",function(){
		$(".menu_right").html("<iframe src='product_stock.html' width='' height='' frameborder='0'></iframe>");
	});
})
$(document).ready(function(){
	$(".user_manager").live("click",function(){
		$(".menu_right").html("<iframe src='usermanager.html' width='' height='' frameborder='0'></iframe>");
	});
})

