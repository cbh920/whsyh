
$(document).ready(function(){
	var lis=$(".nav2");
	var a=$("#nav dl");
	for(var i=0;i<lis.length;i++){
		$(lis[i]).live("click",function(){
			var b=$(this).attr("myAttr");
			for(var j=0;j<a.length;j++)
			{
				var c=$(a[j]).attr("myAttr");
				if(c==b){
					if(!$(a[j]).is(":hidden")){
						$(a[j]).hide();
					}else{
						$(a[j]).show();
					}
				}	
			}	
		});
	}
	
});

//商品管理页面跳转
$(document).ready(function(){
	var lis=$(".product a");
//	alert(lis.length);
	$(lis[0]).live("click",function(){
		$(".menu_right").html("<iframe src='product/products.do' width='' height='' frameborder='0'></iframe>");
	});
});

//订单管理页面跳转
$(document).ready(function(){
	var lis=$(".order a");
//	alert(lis.length);
	$(lis[0]).live("click",function(){
		$(".menu_right").html("<iframe src='order/orders.do' width='' height='' frameborder='0'></iframe>");
	});
	$(lis[1]).live("click",function(){
		$(".menu_right").html("<iframe src='order/sent' width='' height='' frameborder='0'></iframe>");
	});
	
});
//会员管理页面跳转
$(document).ready(function(){
	var lis=$(".member a");
//	alert(lis.length);
	$(lis[0]).live("click",function(){
		$(".menu_right").html("<iframe src='member/members.do' width='' height='' frameborder='0'></iframe>");
	});
});

