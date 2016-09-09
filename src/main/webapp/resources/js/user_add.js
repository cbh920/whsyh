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
			});
			
			
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
			
			//验证信息
			$(document).ready(function(){
				var ok1=false;
				var ok2=false;
				var ok3=false;
				
				//邮箱验证：
				$("input[name='email']").on("blur",function(){
					var emails=$("input[name='email']").attr("value");
					var regRex =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
					if(!regRex.test(emails)) {
						$(".emain_span").html("<span style='color :red'>邮箱格式错误！</span>");
		            }else{
		            	$(".emain_span").html("");
		            	ok1=true;
		            }
				});
				//密码一致性验证
				$("input[name='password2']").on("blur",function(){
					var pass1=$("input[name='password']").attr("value");
					var pass2=$("input[name='password2']").attr("value");
					if(pass1==pass2){
						$(".pass_span").html("");
						ok2=true;
					}else{
						$(".pass_span").html("密码不一致！");
					}
					
				});
				//用户名不能为空
				$("input[name='name']").on("blur",function(){
					
					var name=$("input[name='name']").attr("value");
					if(name!=""){
						$(".name_span").html("");
						ok3=true;
					}else{
						$(".name_span").html("用户名不能为空！");
					}
				});
				
				//提交按钮,所有验证通过方可提交
                $('#user_btn').click(function(){
                    if(ok1&&ok2&&ok3){
                        $('form').submit();
                    }else{
                        return false;
                    }
                });
				
			});
			