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
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="<%=path%>/resources/js/bootstrap.min.js"></script>
		
	
</head>
<body>
<div class="container">
	<button type="button" class="btn btn-default" aria-label="Left Align">
	  <span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
	</button>
	
	<button type="button" class="btn btn-default btn-lg">
	  <span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star
	</button>
	
	<div class="alert alert-danger" role="alert">
	  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	  <span class="sr-only">Error:</span>
	  Enter a valid email address
	</div>
	
	
	<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
	<span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>
	<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
	<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
	
	
	<a href="#">Inbox <span class="badge">42</span></a>

	<button class="btn btn-primary" type="button">
		<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
	  	<span class="badge">4</span>
	</button>
	
	<button class="btn btn-primary" type="button">
		<span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>
	  	<span class="badge">4</span>
	</button>
	
	<button class="btn btn-primary" type="button">
		<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
	  	<span class="badge">4</span>
	</button>
	
	
	<div class="alert alert-warning alert-dismissible" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>Warning!</strong> Better check yourself, you're not looking too good.
	</div>
	
	
	<button type="button" id="myButton" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off">
	  Loading state
	</button>
	
	<script>
	  $('#myButton').on('click', function () {
	    var $btn = $(this).button('loading')
	    setTimeout(function(){$btn.button('reset')},3000);
	    
	  })
	</script>
	
	
	<a class="btn btn-primary hide" role="button" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
	  Link with href
	</a>
	<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
	  Button with data-target
	</button>
	<div class="collapse" id="collapseExample">
	  <div class="well">
	    ...
	  </div>
	</div>
	
	
	
</div>

</body>
</html>