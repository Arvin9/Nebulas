<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<base href="<%=basePath%>">

		<title>Nebula</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Bootstrap -->
		<link href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
		
		
		 <!-- Custom styles for this template -->
    	<link href="<%=path%>/resources/css/signin.css" rel="stylesheet">
		<script src="<%=path%>/resources/lib/jquery-1.11.1.js"></script>
		<script src="<%=path%>/resources/js/bootstrap.min.js"></script>
		<script src="<%=path%>/resources/js/dropdown.js"></script>

  </head>
  
  <body>
		<div class="container">

			<form class="form-signin" action="login" method="post">
				<h2 class="form-signin-heading">
					Please sign in
				</h2>
				<label for="inputEmail" class="sr-only">
					Email address
				</label>
				<input type="text" id="userName" name="userName" class="form-control"
					placeholder="Email address" required autofocus>
				<label for="inputPassword" class="sr-only">
					Password
				</label>
				<input type="password" id="password" name="password" class="form-control"
					placeholder="Password" required>
				<div class="checkbox">
					<label>
						<input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">
					Sign in
				</button>
			</form>

		</div>
		<!-- /container -->

	</body>
</html>
