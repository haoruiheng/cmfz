<%@page contentType="text/html;charset=utf-8"%>

		<script type="text/javascript">
 		var idd;
		//页面加载后
		$(function(){
			//表单 查所有
			$("#tableClazz").datagrid({
				url:"${pageContext.request.contextPath}/bz_clazzController/selectAllBz_clazz.do",
				fitColumns:true,//适应网络宽度 配合 列里面的width
				pagination:true,//打开分页工具
				pageSize:5,
				pageList:[5,10,15,20],
				toolbar:"#paclazz",//引入工具栏
				//删/改超链接  变成-按钮  
				onLoadSuccess:function(date){//数据加载完 执行  参数是远程加载的数据
					console.log(date);
					//$.parser.parse('#cc');  解析参数指定的所有子对象
					//$("a[name=optBtn]").paretn();//通过标签属性值选择器  拿到操作.paretn()方法拿到父
					$.parser.parse($("a[name=optBtn]").parent());
				}
			});
		//初始化添加按钮
			$("#productAdd").linkbutton({
				//注册事件  打开窗口
				onClick:function(){
					$("#duihua").dialog("open");
				},
			});
			
		//批量删除功能  按钮
			$("#pidelete").linkbutton({
				onClick:function(){
					//定义数组
					var ids=new Array;
					//获取选中的多行数据  返回数组
					var idd=$("#table1").datagrid("getSelections");
					for (var i = 0; i < idd.length; i++) {
						ids[i]=idd[i].id;
					}
					//向批删发请求
						$.post(
						"${pageContext.request.contextPath}/petController/deleteAll.do",
						"ids="+ids,
						function(){
						$.messager.show({
							title:"系统提示",
							msg:"您已经批量删除成功"
							});
						//添加完成后调用数据表格的 load方法 ：进行自动刷新内容
						$("#table1").datagrid("load");	
						},
						"text");
				}
			});
			
			//初始化-添加对话框
			$("#classduihua").dialog({
				//设置大小
				width: 400,    
   				height: 300,
   				resizable:true, //设置大小可变
   				title:"添加商品",//设置标题
   				modal:true,//模式化窗口
   				closed:true,//关闭窗口
   				href:"${pageContext.request.contextPath}/addEmps.jsp",
   				cache:false//清除缓存
   				
			});
			
			//初始化修改对话框
			$("#updateduihua").dialog({//初始化
				//设置大小
				width:400,
				height:350,
				title:"添加属性",//标题
				resizable:true,//可改变大小
				modal:true,//模式化窗口
				buttons:"#util",//引入工具
				closed:true,//关闭窗口
				href:"${pageContext.request.contextPath}/updateEmps.jsp",
				cache:false//清除缓存
			});
		});
		//操作的  修改/删除功能
		function myFormatter(value, row, idx){
			return "<a  class='l-btn' href='javascript:void(0)'  onclick='queryOne("+row.id+")'>修改</a> <a  class='l-btn' href='javascript:void(0)' onclick='deletep("+row.id+")'>删除</a>";
 		}
 		//标签类型
		function myClazzTagId(value, row, idx){
			//值 改变成  标签类型
			return row.tagId.tagName;
 		}
 		//修改 功能
		function queryOne(id){
				idd=id,//成员变量赋值
				$("#updateduihua").dialog("open");//开启对话框
		}
		//删除-功能
		function deletep(id){
			$.messager.confirm(
				"系统提示",
				"您确定要删除吗？",
				function(r){    
		    		if (r){ 
		    			/* $.post("${pageContext.request.contextPath}/Jspperson/deleteJspperson.do",
						//传参
						"id="+id, */
						$.get("${pageContext.request.contextPath}/Jspperson/deleteJspperson/"+id,
						function(obj){
						$.messager.show({
								title:"系统提示",
								msg:"删除成功",
						});
						$("#table1").datagrid("reload");//自动更新表单数据
						},
						"text");
		    		}
				});
		};
		</script>
			<table class="table" id="tableClazz">
				<thead>
				<tr class="table_header">
 					<th data-options="field:'xx',width:1,checkbox:true"></th>
					
					<th data-options="field:'clzName',width:1">
						班级名称
					</th>
					<th data-options="field:'x',formatter:myClazzTagId,width:1">
						标签
					</th>
					
					<th data-options="field:'xxx',formatter:myFormatter">
						操作
					</th>
				</tr>
				</thead>
			</table>
			<!-- 定义工具栏   -->
			<div id="paclazz">
				<!--   添加按钮 -->
				<a id="productAdd">商品入库</a>	
			</div>
 			<!-- 添加-对话框 -->
			<div id="classduihua"></div>

