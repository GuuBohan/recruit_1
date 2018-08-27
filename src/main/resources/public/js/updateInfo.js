

 function submit(){
	if($("#studentID").val() == "" || $("#password").val()==""){
		alert("请勿为空!");
		return false;
	}else{
		var test=JSON.stringify({"studentID":$("#studentID").val(),"password":$("#password").val()});
		$.ajax({
			type: 'POST',
			url: 'http://localhost:8080/update',
			async: true,
			crossDomain: true,
			data: test, 
			contentType: 'application/json;charset=UTF-8',
			dateType: 'json',
			xhrFields: {
				withCredentials: true
			},
			success: function(data,textStatus){
				if(data == 406){
					$(".spa1").text("用户名输入错误!");
				}else if(data == 407){
					$(".spa4").text("密码错误!");
					$(".spa1").text();
				}else{
					window.location.href="updateInfo";
				}

			},
			error: function(XMLHttpRequest,textStatus,errorThrown){	
				alert("未知错误，请刷新重试或联系可爱的学长");
				
			}
		});
		return;
	}

 }
