<%@ page pageEncoding="utf-8" %>

	<script type="text/javascript">
	$(function(){
		//初始化树
		$("#tree1").tree({
			//远程加载数据  创建功能栏
			url:"${pageContext.request.contextPath}/wesy-json.jsp",
			//注册事件
			onClick:function(node){//参数是 远程加载数据
				//判断是否是叶节点 (获取树 根据isLeaf方法判断是否是叶节点)
				if($("#tree1").tree("isLeaf",node.target)){
					console.log(node.text);
					//则判断面板是否存在(获取面板根据exists方法判断)
					if($("#tabs1").tabs("exists",node.text)){
						//存在则选中
						$("#tabs1").tabs("select",node.text);
					}else{
						//不存在创建
						if(node.text=="学生管理"){
							$("#tabs1").tabs("add",{
							title:node.text,//标题
							closable:true,//关闭窗口按钮
							href:"${pageContext.request.contextPath}/selectAll/studentAll.jsp"
							});
						}
						if(node.text=="班级管理"){
							$("#tabs1").tabs("add",{
							title:node.text,//标题
							closable:true,//关闭窗口按钮
							href:"${pageContext.request.contextPath}/selectAll/clazzAll.jsp"
							});
						}
						if(node.text=="小组管理"){
							$("#tabs1").tabs("add",{
							title:node.text,//标题
							closable:true,//关闭窗口按钮
							href:"${pageContext.request.contextPath}/selectAll/groupAll.jsp"
							});
						}
						if(node.text=="标签管理"){
							$("#tabs1").tabs("add",{
							title:node.text,//标题
							closable:true,//关闭窗口按钮
							href:"${pageContext.request.contextPath}/selectAll/tagAll.jsp"
							});
						}
						if(node.text=="就业城市管理"){
							$("#tabs1").tabs("add",{
							title:node.text,//标题
							closable:true,//关闭窗口按钮
							href:"${pageContext.request.contextPath}/selectAll/cityAll.jsp"
							});
						}
					}
				}
			}
		});
	});


	</script>

<!-- 功能导航栏 -->
<ul id="tree1"></ul>