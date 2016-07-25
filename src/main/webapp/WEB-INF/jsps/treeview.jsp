<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Bootstrap -->
		<link href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
		<script src="<%=path%>/resources/lib/jquery-1.11.1.js"></script>
		<script src="<%=path%>/resources/js/bootstrap.min.js"></script>
		<script src="<%=path%>/resources/js/bootstrap-treeview.js"></script>
</head>
<body>
	<div id="tree" style="width:300px"></div>
	
<script>
	var tree = [
            {
              text: "Parent 1",
              nodes: [
                {
                  text: "Child 1",
                  nodes: [
                    {
                      text: "Grandchild 1"
                    },
                    {
                      text: "Grandchild 2"
                    }
                  ]
                },
                {
                  text: "Child 2"
                }
              ]
            },
            {
              text: "Parent 2"
            },
            {
              text: "Parent 3"
            },
            {
              text: "Parent 4"
            },
            {
              text: "Parent 5"
            }
          ];
	function getTree() {
	  // Some logic to retrieve, or generate tree structure
	  return tree;
	}

	$('#tree').treeview({data: getTree()});
	
</script>

</body>
</html>