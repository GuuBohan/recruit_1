$(function(){
	var submit = document.getElementById("submit");
	submit.onclick = function(event){
		dataserial = $('form').serialize();
		var dataJson = JSON.stringify(dataserial);
		$.ajax({
			type: 'POST',
			url: 'localhost:8080/register',
			data: dataJson,
			contentType: 'application/json;charset=UTF-8',
			dateType: 'json',
			success: function(data,state){
				// alert("提交成功!");
				// alert(dataJson);
				if(state == 200){
					alert("提交成功!");
				}
				
			},
			error: function(xhr,type){	
				//window.location.href = "updateInfo.html";
				alert("提交失败!"+type);
				
			}
		});
		return false;
	};

	
}) 