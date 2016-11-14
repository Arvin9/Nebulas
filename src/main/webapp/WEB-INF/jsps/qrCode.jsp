<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="site.nebulas.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="java.io.File" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<!-- Bootstrap -->
	<link href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=path%>/resources/css/chat.css" rel="stylesheet">
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="<%=path%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=path%>/resources/qrcode/qrcode.min.js"></script>	
</head>
<body>
<div class="container">

	<input id="text" type="text" value="http://jindo.dev.naver.com/collie" style="width:80%" /><br />

	<div id="qrcode" style="width:100px; height:100px; margin-top:15px;"></div>
	
</div>
<script type="text/javascript">
	var qrcode = new QRCode(document.getElementById("qrcode"), {
		width : 500,
		height : 500
	});
	
	function makeCode () {		
		var elText = document.getElementById("text");
		
		if (!elText.value) {
			alert("Input a text");
			elText.focus();
			return;
		}
		
		qrcode.makeCode(elText.value);
	}
	
	makeCode();
	
	$("#text").
		on("blur", function () {
			makeCode();
		}).
		on("keydown", function (e) {
			if (e.keyCode == 13) {
				makeCode();
			}
		});
</script>
</body>
</html>