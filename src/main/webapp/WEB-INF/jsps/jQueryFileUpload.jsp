<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>jQuery File Upload Example</title>

<style type="text/css">
.bar {
    height: 18px;
    background: green;
}		
#dropzone {
    background: palegreen;
    width: 150px;
    height: 50px;
    line-height: 50px;
    text-align: center;
    font-weight: bold;
}
#dropzone.in {
    width: 600px;
    height: 200px;
    line-height: 200px;
    font-size: larger;
}
#dropzone.hover {
    background: lawngreen;
}
#dropzone.fade {
    -webkit-transition: all 0.3s ease-out;
    -moz-transition: all 0.3s ease-out;
    -ms-transition: all 0.3s ease-out;
    -o-transition: all 0.3s ease-out;
    transition: all 0.3s ease-out;
    opacity: 1;
}

</style>

</head>
<body>
	
	
	<input id="fileupload" type="file" multiple>

	<div id="dropzone" class="fade well">
		
		Drop files here
		
	
	</div>
	<div id="progress">
		<div class="bar" style="width: 0%;"></div>
	</div>

<script src="<%=path%>/resources/js/jquery-2.1.4.min.js"></script>
<script src="<%=path%>/resources/js/vendor/jquery.ui.widget.js"></script>
<script src="<%=path%>/resources/js/jquery.iframe-transport.js"></script>
<script src="<%=path%>/resources/js/jquery.fileupload.js"></script>
<script src="<%=path%>/resources/md5.js"></script>

<script>
$(function () {
    $('#fileupload').each(function (){
    	$(this).fileupload({
	        dataType: 'json',
	        dropZone: $('#dropzone'),
	        url: 'jQueryFileUploadFile',
	        paramName: 'uploadFile',
	        //singleFileUploads :false,
	        //sequentialUploads : true,
			add: function (e, data) {
				alert(data);
	            data.context = $('<p/>').text('Uploading...').appendTo(document.body);
	            $.each(data.files, function (index, file) {
	                console.log('add file: ' + file.name);
	                document.getElementById("progress").innerHTML += 
		        		"<p id = \"p"+file.name+"\">"+file.name+"</p><div class=\"bar\" id = \""+file.name+"\"style=\"width: 0%;\"></div>"
	                
	            });
	            data.submit();
	        },	        
	        drop: function (e, data) {
	        	console.log('drop');
	        	console.log(data);
	            $.each(data.files, function (index, file) {
	                console.log('Dropped file: ' + file.name);
	                document.getElementById("progress").innerHTML += 
		        		"<p id = \"p"+file.name+"\">"+file.name+"</p><div class=\"bar\" id = \""+file.name+"\"style=\"width: 0%;\"></div>"
	                
	            });
	        },
	        change: function (e, data) {
	            $.each(data.files, function (index, file) {
	            	console.log('Selected file: ' + file.name);
	            });
	        },
	        done: function (e, data) {
	        	console.log('done');
	        	console.log(data);
	            $.each(data.result.files, function (index, file) {
	            	console.log(file);
	            	console.log(index);
	            	console.log(file.name);
	                $('<p/>').text(file.name).appendTo(document.body);
	            });
	        },
		    progress: function (e, data) {
			    var progress = parseInt(data.loaded / data.total * 100, 10);
			    document.getElementById(data.files[0].name).style.width = progress + '%';
		        document.getElementById(data.files[0].name).innerHTML = progress + '%';
		    },
		    processdone: function (e, data) {
		    	alert('Processing ' + data.files[data.index].name + ' done.');
		    } 
    	});
    
    });
    
    
    
});


console.log(hex_md5("CHh"));
console.log(hex_md5("chh"));
console.log(b64_md5("chh"));
</script>
</body> 
</html>