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
    	
		<script  src="<%=path%>/resources/lib/jquery-1.11.1.js"></script>
		<script src="<%=path%>/resources/js/bootstrap.min.js"></script>		
		<script src="<%=path%>/resources/js/dropdown.js"></script>
		<!-- 表单验证 -->
		
		<script  src="<%=path%>/resources/dist/jquery.validate.js" type="text/javascript"></script>
		<script  src="<%=path%>/resources/dist/additional-methods.js" type="text/javascript"></script>
	</head>
  
  <body>



	<div class="container">

		<!-- 动态包含 -->
		<jsp:include page="page/top.jsp"></jsp:include>

		<div class="panel panel-default">
			<div class="panel-heading">CONTCT FORM</div>
			<div class="panel-body">

				<div class="mes-fig">
					<span> </span>
				</div>
				<form id="signupForm" class="form-horizontal" action="/sendMail" method="post">
					<div class="form-group">
						<label class="col-sm-1 control-label" for="name">Name:</label>
						<div class="col-sm-3">
							<input type="text" id="name" name="name" class="form-control"
								placeholder="Your Name">
						</div>
					</div>


					<div class="form-group">
						<label class="col-sm-1 control-label">Email:</label>
						<div class="col-sm-3">
							<input type="text" id="email" name="email" class="form-control"
								placeholder="Your Email">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label"> Subject: </label>
						<div class="col-sm-3">
							<input type="text" id="subject" name="subject" class="form-control"
								placeholder="Subject">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label"> Message: </label>
						<div class="col-sm-8">
							<textarea id="message" name="message" class="form-control" rows="8"
								placeholder="Message"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-1"></div>
						<div class="col-sm-6">
							<button type="submit" class="btn btn-primary btn-lg">
								Send</button>
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
<script type="text/javascript">

$.validator.setDefaults( {
	submitHandler: function () {
		alert( "消息提交成功!" );
		form.submit();
	}
} );


	
	
	$().ready(function() {
		
		
		$( "#signupForm" ).validate( {
			rules: {
				name:{
					required: true,
					minlength: 2
				},
				email:{
					required: true,
					email: true
				},
				subject: "required",
				message: "required"

			},
			messages: {
				name: {
					required: "请输入你的名字",
					minlength: "Your username must consist of at least 2 characters"
				},
				email: "请输入有效邮箱地址",
				subject:"请输入主题",
				message:"请输入信息"
				
			},
			errorElement: "em",
			errorPlacement: function ( error, element ) {
				// Add the `help-block` class to the error element
				error.addClass( "help-block" );
		
				// Add `has-feedback` class to the parent div.form-group
				// in order to add icons to inputs
				element.parents( ".col-sm-5" ).addClass( "has-feedback" );
		
				if ( element.prop( "type" ) === "checkbox" ) {
					error.insertAfter( element.parent( "label" ) );
				} else {
					error.insertAfter( element );
				}
		
				// Add the span element, if doesn't exists, and apply the icon classes to it.
				if ( !element.next( "span" )[ 0 ] ) {
					$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
				}
			},
			success: function ( label, element ) {
				// Add the span element, if doesn't exists, and apply the icon classes to it.
				if ( !$( element ).next( "span" )[ 0 ] ) {
					$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
				}
			},
			highlight: function ( element, errorClass, validClass ) {
				$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
				$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
			},
			unhighlight: function ( element, errorClass, validClass ) {
				$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
				$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
			}
		} );
	} );
	</script>