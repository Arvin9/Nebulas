<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!-- Bootstrap -->
	<link href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=path%>/resources/css/chat.css" rel="stylesheet">
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="<%=path%>/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<br>
<br>
<br>
<br>
<br>
		<!-- Area Charts:Morris --><!-- Chat -->
		<div class="col-sm-offset-2 col-sm-6">
			<div class="widget-container scrollable chat" style="height: 520px;">
				<div class="heading">
					<i class="icon-comments"></i>客服机器人<i class="icon-smile pull-right"></i>
				</div>
				<div class="widget-content padded" id="scroll">
					<ul id="scrolValue">
						<!--  
						<li>
							<img width="30" height="30" src="images/avatar-male.jpg" />
							<div class="bubble">
								<a class="user-name" href="#">客服机器人</a>
								<p class="message">您好，我是客服机器人，有什么可以帮您的吗？</p>
								<p class="time">
									<strong>今天 </strong>下午 3:53
								</p>
							</div>
						</li>
						<li class="current-user">
							<img width="30" height="30" src="images/avatar-female.jpg" />
							<div class="bubble">
								<a class="user-name" href="#">王晓</a>
								<p class="message">尽管你一脸不真诚，但我听着很高兴。——《梦想照进现实》</p>
								<p class="time">
									<strong>今天 </strong>下午 3:53
								</p>
							</div>
						</li>
						-->
					</ul>
				</div>
				<div class="post-message">
					<input class="form-control" placeholder="请输入您需要发送的信息…" type="text" id="sendMessage"  
							onkeydown='if(event.keyCode==13){sendMessage(); $("#sendMessage").val(""); }'>
					<input type="submit" onclick="sendMessage()"  value="发送">
				</div>
			</div>
		</div>
		<!-- End Chat -->


	</div>
	
	<script >
	$(function(){
		//滚动条置底
		document.getElementById('scroll').scrollTop = document.getElementById('scrolValue').scrollHeight;
		$.post("askRobot", { message: "你好"},function(data){
			var obj = $.parseJSON(data);
			console.log(obj);
			var content = '<li>'+ 
						      '<img width="30" height="30" src="resources/images/icon36.png" />' + 
							  '<div class="bubble">' + 
							     '<a class="user-name" href="#">客服机器人</a>' + 
								 '<p class="message">'+ obj.text +'</p>' + 
								 '<p class="time">' + 
								     '<strong>今天 </strong>' + getTime() + 
								 '</p>' + 
							   '</div>' + 
						  '</li>';
			$('#scrolValue').append(content);
			//滚动条置底
			document.getElementById('scroll').scrollTop = document.getElementById('scrolValue').scrollHeight;
		});
	});
	function sendMessage(){
		var userMessage = $('#sendMessage').val();
		if (!userMessage) return;
		var userAccount = "游客";
		var userContent = '<li class="current-user">'+ 
						      '<img width="30" height="30" src="resources/images/500137.gif" />' + 
							  '<div class="bubble">' + 
							     '<a class="user-name" href="#">'+ userAccount + '</a>' + 
								 '<p class="message">'+ userMessage +'</p>' + 
								 '<p class="time">' + 
								     '<strong>今天 </strong>' +  getTime() + 
								 '</p>' + 
							   '</div>' + 
						  '</li>';
		$('#scrolValue').append(userContent);
		//滚动条置底
		document.getElementById('scroll').scrollTop = document.getElementById('scrolValue').scrollHeight;
		$.post("askRobot", { message: userMessage},function(data){
			var obj = $.parseJSON(data);
			console.log(obj);
			var content = '<li>'+ 
						      '<img width="30" height="30" src="resources/images/icon36.png" />' + 
							  '<div class="bubble">' + 
							     '<a class="user-name" href="#">客服机器人</a>' + 
								 '<p class="message">'+ obj.text +'</p>' + 
								 '<p class="time">' + 
								     '<strong>今天 </strong>' +  getTime() + 
								 '</p>' + 
							   '</div>' + 
						  '</li>';
			$('#scrolValue').append(content);
			//滚动条置底
			document.getElementById('scroll').scrollTop = document.getElementById('scrolValue').scrollHeight;
		});
	}
	
	function getTime(){
		//获得当前时间 如,16:12:30
		var myDate = new Date();
		var hour = myDate.getHours();         //获取当前小时数(0-23)
	    var minute = myDate.getMinutes();     //获取当前分钟数(0-59)
	    minute = minute<10?('0'+minute):minute
		var second = myDate.getSeconds();     //获取当前秒数(0-59)
		second = second<10?('0'+second):minute
		return hour + ':' + minute + ':' + second;
	}
	
	
	</script>
</body>
</html>