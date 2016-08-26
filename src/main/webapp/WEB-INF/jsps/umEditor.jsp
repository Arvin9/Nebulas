<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>UMeditor</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Bootstrap -->
		<link href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
		<script src="http://code.jquery.com/jquery.js"></script>
		<link href="<%=path%>/resources/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
	    <script type="text/javascript" charset="utf-8" src="<%=path%>/resources/umeditor/umeditor.config.js"></script>
	    <script type="text/javascript" charset="utf-8" src="<%=path%>/resources/umeditor/umeditor.min.js"></script>
	    <script type="text/javascript" src="<%=path%>/resources/umeditor/lang/zh-cn/zh-cn.js"></script>
		<style type="text/css">
        h1{
            font-family: "微软雅黑";
            font-weight: normal;
        }
        .btn {
            display: inline-block;
            *display: inline;
            padding: 4px 12px;
            margin-bottom: 0;
            *margin-left: .3em;
            font-size: 14px;
            line-height: 20px;
            color: #333333;
            text-align: center;
            text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
            vertical-align: middle;
            cursor: pointer;
            background-color: #f5f5f5;
            *background-color: #e6e6e6;
            background-image: -moz-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#e6e6e6));
            background-image: -webkit-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: -o-linear-gradient(top, #ffffff, #e6e6e6);
            background-image: linear-gradient(to bottom, #ffffff, #e6e6e6);
            background-repeat: repeat-x;
            border: 1px solid #cccccc;
            *border: 0;
            border-color: #e6e6e6 #e6e6e6 #bfbfbf;
            border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
            border-bottom-color: #b3b3b3;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            border-radius: 4px;
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff', endColorstr='#ffe6e6e6', GradientType=0);
            filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
            *zoom: 1;
            -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
            -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
            box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
        }

        .btn:hover,
        .btn:focus,
        .btn:active,
        .btn.active,
        .btn.disabled,
        .btn[disabled] {
            color: #333333;
            background-color: #e6e6e6;
            *background-color: #d9d9d9;
        }

        .btn:active,
        .btn.active {
            background-color: #cccccc \9;
        }

        .btn:first-child {
            *margin-left: 0;
        }

        .btn:hover,
        .btn:focus {
            color: #333333;
            text-decoration: none;
            background-position: 0 -15px;
            -webkit-transition: background-position 0.1s linear;
            -moz-transition: background-position 0.1s linear;
            -o-transition: background-position 0.1s linear;
            transition: background-position 0.1s linear;
        }

        .btn:focus {
            outline: thin dotted #333;
            outline: 5px auto -webkit-focus-ring-color;
            outline-offset: -2px;
        }

        .btn.active,
        .btn:active {
            background-image: none;
            outline: 0;
            -webkit-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
            -moz-box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
            box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.15), 0 1px 2px rgba(0, 0, 0, 0.05);
        }

        .btn.disabled,
        .btn[disabled] {
            cursor: default;
            background-image: none;
            opacity: 0.65;
            filter: alpha(opacity=65);
            -webkit-box-shadow: none;
            -moz-box-shadow: none;
            box-shadow: none;
        }
    </style>
	</head>
	
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-offset-2 col-md-8">
					<!--style给定宽度可以影响编辑器的最终宽度-->
					<script type="text/plain" id="myEditor"  style="width:100%;height:100%;">
    					<p>这里我可以写一些输入提示</p>
					</script>
				</div>
			</div>
			<div class="row">
				<div id="btns" class="col-md-offset-2">
					<button class="btn" onclick="getContent()">提交</button>&nbsp;
					<button class="btn" onclick="setContent()">写入内容</button>&nbsp;
				</div>
				<div class="clear"></div>
			</div>
			<h3 id="focush2"></h3>
		</div>
		
		<script type="text/javascript">
		    //实例化编辑器
		    var um = UM.getEditor('myEditor',{
		    	
		    	/* 传入配置参数,可配参数列表看umeditor.config.js */
	            toolbar: [
					'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
					'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize' ,
					'| justifyleft justifycenter justifyright justifyjustify |',
					'link unlink ',
					'| horizontal print preview fullscreen',  'formula'
				]
		    });
		   
		    //按钮的操作
		    function getContent() {
		    	if(!UM.getEditor('myEditor').hasContents()){
		    		alert("不可提交空内容");
		    		return;
		    	}
		        var arr = [];
		        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
		        arr.push("内容为：");
		        arr.push(UM.getEditor('myEditor').getContent());
		        alert(arr.join("\n"));
		    }
		    function setContent(isAppendTo) {
		        var arr = [];
		        arr.push("使用editor.setContent('欢迎使用umeditor')方法可以设置编辑器的内容");
		        UM.getEditor('myEditor').setContent('欢迎使用umeditor', isAppendTo);
		        alert(arr.join("\n"));
		    }
		    function hasContent() {
		        var arr = [];
		        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
		        arr.push("判断结果为：");
		        arr.push(UM.getEditor('myEditor').hasContents());
		        alert(arr.join("\n"));
		    }
		    
		    
		</script>
	</body>
</html>