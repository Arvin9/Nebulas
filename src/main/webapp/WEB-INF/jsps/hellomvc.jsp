<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="site.nebulas.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="java.io.File" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
hello hhh
<% 
	String str = TxtUtil.readTxtFile("tag.txt");
	String userDir = new File(TxtUtil.class.getResource("/").getPath()).toString();
	String classPath = TxtUtil.class.getClassLoader().getResource("/").getPath();
	String ss = File.separator;
	
%>
<br>
<%=userDir %>
<br>
<%=classPath %>

<br>
<%=ss %>
<br>
<%=str %>
</body>
</html>