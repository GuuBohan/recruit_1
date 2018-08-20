/*表单验证部分*/
//window.onload = function(){
//		$("#studentID").focus();
//}
$("input").blur(function(){
	if($(this).is("#studentID")){
		var patternID = /^[B|Q|H]{1}1[5|6|7|8]\d{6}$/;
		if($("#studentID").val()!=""){
			if(!patternID.test($("#studentID").val())){
				$(".spa1").text("学号格式有误!");
				return false;
			}else if(patternID){
				$(".sp1").text("");
				return true;
			}
		}else{
			$(".spa1").text("请勿为空!");
			return false;
		}
	}
	if($(this).is("#studentName")){
		var patternName = /^[\u0391-\uFFE5]+$/;
		var patternName2 = /^[\u0391-\uFFE5]{2,5}$/;
		if($("#studentName").val()!=""){
			if(!patternName.test($("#studentName").val())){
				$(".spa2").text("请输入中文字符!");
				return false;
			}else if(!patternName2.test($("#studentName").val())){
				$(".spa2").text("姓名长度有误!");
				return false;
			}else{
				$(".spa2").text("");
				return true;
			}
		}else{
			$(".spa2").text("请勿为空!");
			return false;
		}
	}
	if($(this).is("#phoneNumber")){
				var patternNumber = /^1[3|5|7|8|][0-9]{9}$/;
				if($("#phoneNumber").val()!= ""){
					if(!patternNumber.test($("#phoneNumber").val())){
						$(".spa3").text("号码格式有误!");
						return false;
					}else{
						$(".spa3").text("");
						return true;
					}
				}else{
					$(".spa3").text("请勿为空!");
					return false;
				}
	}
	if($(this).is("#resetPassword")){
		if($("#resetPassword").val()!= ""){
			$(".spa4").text("");
			return true;
		}else{
			$(".spa4").text("请勿为空!");
			return false;
		}
	}
	
})

$("input").focus(function(){
				if($(this).is("#studentID")){
					$(".spa1").text("");
				}
			   if($(this).is("#studentName")){
				   $(".spa2").text("");
				}
			   if($(this).is("#phoneNumber")){
			   	$(".spa3").text("");
			   }
			   if($(this).is("#resetPassword")){
			   	$(".spa4").text("");
			   }
})
$("select").blur(function(){
		if($(this).is("#intention_1")){
			if($("#intention_1").val()!=""){
				$(".spa5").text("");
				return true;
			}else{
				$(".spa5").text("请勿为空!");
				return false;
			}
		}
		if($(this).is("#intention_2")){
			if($("#intention_2").val()!=""){
				$(".spa6").text("");
				return true;
			}else{
				$(".spa6").text("请勿为空!");
				return false;
			}
		}
})
$("select").focus(function(){
	if($(this).is("#intention_1")){
		$(".spa5").text("");
	}
	if($(this).is("#intention_1")){
		$(".spa5").text("");
	}
})


