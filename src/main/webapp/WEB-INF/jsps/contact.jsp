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

			<div class="panel panel-default">
				<div class="panel-heading">
					CONTCT FORM
				</div>
				<div class="panel-body">

					<div class="mes-fig">
						<span> </span>
					</div>
					<form class="form-horizontal" action="<%=path%>/contact/Contact_sendMail.action" method="post">
						<div class="form-group">
							<label class="col-sm-1 control-label">Name:</label>
							<div class="col-sm-3">
								<input type="text" name="name" class="form-control" placeholder="Your Name" required=" ">
							</div>
						</div>
						<div class="form-group">
							<label  class="col-sm-1 control-label">Email:</label>
							<div class="col-sm-3">
							<input type="text" name="email" class="form-control" placeholder="Your Email" required=" ">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label">
								Subject:
							</label>
							<div class="col-sm-3">
								<input type="text" name="subject" class="form-control" placeholder="Subject"
									required=" ">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-1 control-label">
								Message:
							</label>
							<div class="col-sm-8">
								<textarea name="message" class="form-control" rows="8" placeholder="Message"
								required=" "></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-1">
							</div>
							<div class="col-sm-6">
								<button  type="submit" class="btn btn-primary btn-lg">
									Send
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>

			<!-- FOOTER -->
			<!-- 静态包含 -->
			<%@include file="page/foot.jsp"%>

		</div>

	</body>
</html>
