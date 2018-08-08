/*粒子绘画部分*/
var ctx = document.getElementById('canvas'),
		content = ctx.getContext('2d'),
		round=[],
		WIDTH,
		HEIGHT,
		initRoundPopulation = 8;
		WIDTH = document.documentElement.clientWidth;
		HEIGHT = document.documentElement.clientHeight;
		ctx.width = WIDTH;
		ctx.height = HEIGHT;
function Round_item(index,x,y){
			this.index =index;
			this.x = x;
			this.y = y;
			this.r = Math.random()*(13-7)+7;
			var alpha = (Math.floor(Math.random()*10)+1) /10 /2;
			var r = Math.floor(Math.random()*(255-135)+135);
			var g = Math.floor(Math.random()*(255-240)+240);
			var b = Math.floor(Math.random()*(255-240)+240);
			this.color = "rgba("+r+","+g+","+b+","+ alpha+")";
			 }
Round_item.prototype.draw = function(){
			content.beginPath();
			content.arc(this.x,this.y,this.r,0,2*Math.PI,false);
			content.closePath();
			content.shadowBlur = this.r *2;
			content.fillStyle = this.color;
			content.fill();

		};
function animate(){
			content.clearRect(0,0,WIDTH,HEIGHT);
			for(var i in round){
				round[i].move();
			}
			requestAnimationFrame(animate);
		}
Round_item.prototype.move = function(){
			this.y -=0.75;
			if(this.y <= -7){
				this.y = HEIGHT + 10;
			}
			this.draw();
		};
		function init(){
			for(var i = 0;i<initRoundPopulation;i++){
				round[i] = new Round_item(i,Math.random()*WIDTH,Math.random()*HEIGHT);
				round[i].draw();
			}
			animate();
		}
init();
/*表单通信部分*/


// function submitData(){
// var xhr = new XMLHttpRequest();
// xhr.onreadystatechange = function(){
// 	if(xhr.readyState == 4){
// 		if((xhr.status >= 200 && xhr.status <300) || xhr.status == 304){
// 			alert(xhr.responseText);
// 		}else{
// 			alert("请求失败：" + xhr.status) ;
// 		}
// 	}
// };
// xhr.open("post","../Recruit/src/main/java/com/cast/recruit/controller/RegisterController.java",true);
// xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
// var form = document.getElementById("user-apply");
// xhr.send(serialize(form));

// }
var data ={};
data = $('#user-apply').serialize();
$.ajax({
	type: 'POST',
	url:'localhost:8080/register',
	data: JSON.stringify(data),
	contentType: 'application/json; charset=UTF-8',
	dataType: 'json',
	success: function(data){
		alert("提交成功！");
	},
	error: function(xhr,type){
		alert("提交失败！");
	}

});