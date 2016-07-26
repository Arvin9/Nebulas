<div class="col-md-3">
	<div>
		<ul id="treeDemo" class="ztree"></ul>
	</div>
</div>

<SCRIPT LANGUAGE="JavaScript">
   var zTreeObj;
   // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
   var zNodes;
   // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
   var setting = {
		async: {
			enable: true,
			url: "/queryMenu?roleId=10000"
		},
		data: {
			key: {
				name: "menuName",
				url: "menuUrl"
			},
			simpleData: {
				enable: true,
				idKey: "menuId",
				pIdKey: "parentId",
				rootPId: "root"
			}
		}
   };

   
   
   $(document).ready(function(){
	  
      zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
      
   });
  </SCRIPT>