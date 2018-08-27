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

//AJAX通信部分
$(function(){
	var dateserial ={};
	dataserial = $('form').serialize();
		var dataJson = JSON.stringify(dataserial);
		$.ajax({
			type: 'POST',
			url: 'http://localhost:8080/register',
			data: dataJson,
			contentType: 'application/json;charset=UTF-8',
			dateType: 'json',
			success: function(data){
			},
			error: function(XHTTPRequest,state){
				// alert("这是我自己写的弹窗!");
				console.log("这是彩蛋哦!");
			}
		});
})
