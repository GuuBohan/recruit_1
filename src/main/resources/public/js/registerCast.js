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


// var dateserial = {};
// dateserial = $("#user-apply").serialize();
// $.ajax({
// 	type: 'POST',
// 	url: 'localhost:8080/register',
// 	data: JSON.stringify(data1),
// 	contentType: 'application/json; charset=UTF-8',
// 	dataType: 'json',
// 	success: function(data){
// 		console.log(data1);
// 	},
// 	error: function(xhr,type){
		
// 	}
// });
var dateserial ={};
	dataserial = $('form').serialize();
	var dataJson = JSON.stringify(dataserial);
	// console.log(dateserial);
	// console.log(dateJson);
	$.ajax({
		type: 'POST',
		url: 'localhost:8080/register',
		data: dataJson,
		contentType: 'application/json;charset=UTF-8',
		dateType: 'json',
		success: function(data){
			// alert("提交成功!");
			// alert(dataJson);
		},
		error: function(xhr,type){	
			// alert("提交失败!"+dataJson);
			// alert(dataJson);
		}
	});