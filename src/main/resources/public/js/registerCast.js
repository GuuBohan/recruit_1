//密码可视化
var eyeOfGod = document.getElementById("eyeOfGod");
var resetPassword = document.getElementById("password");
function hideShowPsw(){
	if (resetPassword.type == "password") {
	resetPassword.type = "text";
	$("#password").css("margin-left","1em");
	eyeOfGod.src = "../public/images/invisible.png";
}else {
	resetPassword.type = "password";
	eyeOfGod.src = "../public/images/visible.png";
	}
}
$("#password").blur(function(){
	resetPassword.type = "password";
	eyeOfGod.src = "../public/images/visible.png";
})

/*表单通信部分*/
//$("#submit").submit(function(){
//	$("#submit").preventDefault();
//	if(resetPassword.type == "text"){
//		resetPassword.type = "password";
//		eyeOfGod.src ="../public/images/visible.png";
//		alert("修改成功!");
//	}
////	var data ={};
////	data = $('#user-apply').serialize();
////	$.ajax({
////	type: 'POST',
////	url:'localhost:8080/register',
////	data: JSON.stringify(data),
////	contentType: 'application/json; charset=UTF-8',
////	dataType: 'json',
////	success: function(data){
////		alert("提交成功！");
////	},
////	error: function(xhr,type){
//////		alert("提交失败！");
////	}
////});	
//	
//})
var date = {};
date = $("#user-apply").serialize();
$.ajax({
	type: 'POST',
	url: 'localhost:8080/register',
	data: JSON.stringify(data),
	contentType: 'application/json; charset=UTF-8',
	dataType: 'json',
	stat
	success: function(data){
		window.location.href = "success.html";
	},
	error: function(xhr,type){
		window.location.href = "success.html";
	}
});