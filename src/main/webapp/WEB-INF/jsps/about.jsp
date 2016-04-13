<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    	<link href="<%=path%>/resources/css/footer.css" rel="stylesheet">
		
		<script src="<%=path%>/resources/js/bootstrap.min.js"></script>
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="<%=path%>/resources/js/dropdown.js"></script>

  </head>
  
  <body>
		<div class="container">

			<!-- 动态包含 -->
			<jsp:include page="page/top.jsp"></jsp:include>

			<!-- Main component for a primary marketing message or call to action -->
			<div class="jumbotron">
				<h1>
					Just for me
				</h1>
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;
						Everything that we do is a step in one direction or another. 
					Even the failure to do something is in itself a deed. 
					it sets us forward or backward. 
					the action of the negative pole of a magnetic needle is just as real as the action of the positive pole. 
					To decline is to accept--the other alternative.
				</p>


				<p>
					<a class="btn btn-lg btn-primary" href="" role="button">View
						navbar docs &raquo;</a>
				</p>
			</div>


			<!-- FOOTER -->
			<!-- 静态包含 -->
			<%@include file="page/foot.jsp"%>

		</div>
	</body>
</html>
