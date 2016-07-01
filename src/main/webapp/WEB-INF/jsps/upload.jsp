<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>upload</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Bootstrap -->
		<link href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
		<link href="<%=path%>/resources/css/dropzone.css" rel="stylesheet">
		<link href="<%=path%>/resources/css/style.css" rel="stylesheet">
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="<%=path%>/resources/js/dropzone.js"></script>
		
	</head>
	
	<body>


		<form id="dropz"  class="dropzone needsclick dz-clickable"  >
    			
    	</form>
		
		
		<script>
			//初始化dropzone
		    $("#dropz").dropzone({
		        url: "/uploadFile",
		        method: "post",
		        paramName: "uploadFile",
		        enctype: "multipart/form-data",
		        //限制最多上传文件数量
		        maxFiles: 3,
		       	// 最大文件大小，单位是 MB。
		        maxFilesize: 8,
		        //允许上传文件格式
		        acceptedFiles: ".rar,.zip,.pdf,.txt,.xls,.xlsx,.js,.doc,.docx",
		        //给文件添加删除连接
		        addRemoveLinks: true,
		        //取消上传提示文本
		        dictCancelUpload: "取消上传",
		        //确认取消上传文本
		        dictCancelUploadConfirmation: "是否取消上传",
		        //删除上传文件文本
		        dictRemoveFile: "删除文件",
		        //没有任何文件是提示的文本
		        dictDefaultMessage: "请将需要上传的文件拖拽到此处",
		        //文件类型被拒绝时的提示文本。
		        dictInvalidFileType: "暂不支持你的文件类型,请确认后重试",
		        //文件大小过大时的提示文本。
		        dictFileTooBig: "您的文件过大,最大允许上传文件大小为8M",
		        
				init: function() {
					this.on("success", function(file) {
		                console.log("File " + file.name + "uploaded");
		            });
		            this.on("removedfile", function(file) {
		                console.log("File " + file.name + "removed");
		            });
		    	}
		    });
		</script>
	</body>
</html>