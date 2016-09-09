$(document).ready(function(){
	$("#selectAll").on("click",function(){
		if($("#selectAll").attr("checked")=="checked"){
//			alert("a");
			$("[myBox='checkbox']").attr("checked",'true');//全选
		}else{
			$("[myBox='checkbox']").removeAttr("checked");//取消全选
		}
	})
})