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
<title>角色管理</title>
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
             url: "<%=path%>/queryManage",
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
                        field: 'mId',
                        align: 'center',
                        valign: 'middle'
                    },{
                        title: '角色ID',
                        field: 'roleId',
                        align: 'left',
                        valign: 'middle',
                        sortable: true
                    },{
                        title: '名称',
                        field: 'managerAccount',
                        align: 'center',
                        valign: 'middle',
                        sortable: true
                    },{
                        title: '真实姓名',
                        field: 'realName',
                        align: 'center',
                        valign: 'middle',
                        sortable: true
                    },{
                        title: '添加时间',
                        field: 'addTime',
                        align: 'left',
                        valign: 'middle',
                        sortable: true
                    },{
                        title: '是否被锁',
                        field: 'isLock',
                        align: 'center',
                        valign: 'middle',
                        sortable: true
                    },{
                        title: '添加人',
                        field: 'addMan',
                        align: 'center',
                        valign: 'middle',
                        sortable: true
                    },{
                        title: 'balance',
                        field: 'balance',
                        align: 'center',
                        valign: 'middle',
                        sortable: true
                    },{
                        title: '是否被删除',
                        field: 'isDelete',
                        align: 'center',
                        valign: 'middle',
                        sortable: true
                    }]
        })
        
    })

</script>

</body>
</html>