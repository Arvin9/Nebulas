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
	<link href="<%=path%>/resources/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
	<link href="<%=path%>/resources/ztree/css/demo.css" type="text/css" rel="stylesheet">
	<link href="<%=path%>/resources/ztree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">

	<script src="<%=path%>/resources/lib/jquery-1.11.1.js"></script>
	<script src="<%=path%>/resources/bootstrap-table/bootstrap-table.min.js"></script>
  	<script src="<%=path%>/resources/ztree/js/jquery.ztree.core.min.js" type="text/javascript" ></script>
 	<script src="<%=path%>/resources/ztree/js/jquery.ztree.exedit.min.js" type="text/javascript" ></script>
</head>
<body>

	<div class="container">
		<!-- 动态包含 -->
		<jsp:include page="page/top.jsp"></jsp:include>
	
		
		<div class="row">
		
			<jsp:include page="page/nav.jsp"></jsp:include>
			
			<div class="col-md-9">
				<table id="table"></table>
			
			</div>
		</div>
		
	</div>




<script>
    $(function() {
    	$('#table').bootstrapTable({
    		 method: 'get',
             url: "<%=path%>/queryMenu",
             cache: false,
             height: 600,
             striped: true,
             pagination: true,
             pageSize: 20,
             pageList: [5,10, 25, 50, 100, 200],
             contentType: "application/x-www-form-urlencoded",
             search: true,
             showColumns: true,
             showRefresh: true,
             minimumCountColumns: 2,
             clickToSelect: true,
             singleSelect : false,
             columns: [{
            	 		title: 'ID',
                        field: 'id',
                        align: 'center',
                        valign: 'middle'
                    },{
                        title: '菜单ID',
                        field: 'menuId',
                        align: 'left',
                        valign: 'middle',
                        sortable: true
                    },{
                        title: '菜单名称',
                        field: 'menuName',
                        align: 'center',
                        valign: 'middle',
                        sortable: true
                    },{
                        title: '父节点 ID',
                        field: 'parentId',
                        align: 'center',
                        valign: 'middle',
                        sortable: true
                    },{
                        title: '菜单Url',
                        field: 'menuUrl',
                        align: 'left',
                        valign: 'middle',
                        sortable: true
                    },{
                        title: '有效状态',
                        field: 'available',
                        align: 'center',
                        valign: 'middle',
                        sortable: true
                    }]
        })
        
    })

</script>

</body>
</html>