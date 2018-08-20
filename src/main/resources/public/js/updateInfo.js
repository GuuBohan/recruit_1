$(function(){
	$("#submit").submit(function(event){
		event.preventDefault();
		
		$.ajax({
			type:"post",
			url:"",
			data:{StudentID:$("#studentID").val(),resetPassword:$("#resetPassword").val()},
			async:false
		});
		
	})
	
	
})