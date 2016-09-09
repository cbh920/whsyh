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
			});

//商品管理页面跳转
$(document).ready(function(){
	$(".good_manager").live("click",function(){
		$(".menu_right").html("<iframe src='product/products' width='' height='' frameborder='0'></iframe>");
	});
});

$(document).ready(function(){
	$(".stock_manager").live("click",function(){
		$(".menu_right").html("<iframe src='product_stock.html' width='' height='' frameborder='0'></iframe>");
	});
});
$(document).ready(function(){
	$(".user_manager").live("click",function(){
		$(".menu_right").html("<iframe src='usermanager.html' width='' height='' frameborder='0'></iframe>");
	});
});


//订单管理页面跳转
$(document).ready(function(){
	var lis=$(".order a");
//	alert(lis.length);
	$(lis[1]).live("click",function(){
		$(".menu_right").html("<iframe src='order/orders' width='' height='' frameborder='0'></iframe>");
	});
});
//会员管理页面跳转
$(document).ready(function(){
	var lis=$(".member a");
//	alert(lis.length);
	$(lis[1]).live("click",function(){
		$(".menu_right").html("<iframe src='member/members' width='' height='' frameborder='0'></iframe>");
	});
});

