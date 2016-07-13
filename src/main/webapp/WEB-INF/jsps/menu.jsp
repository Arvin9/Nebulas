<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
<!-- Bootstrap -->
<link href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
<script  src="<%=path%>/resources/lib/jquery-1.11.1.js"></script>
</head>
<body>
menu

<ul class="nav nav-pills nav-stacked" >
  <li role="presentation" class="active"><a href="#">Home</a></li>
  <li role="presentation"><a href="#">Profile</a></li>
  <li role="presentation"><a href="#">Messages</a></li>
</ul>

<div id="tree"></div>


<c:forEach var="cate" items="${menuTree}" >
		
</c:forEach>

<script>
	var menuTree = ${menuTree};
	var obj = eval(menuTree);
	alert(menuTree.menu[0].length);
	console.log(menuTree);
</script>

</body>
</html>