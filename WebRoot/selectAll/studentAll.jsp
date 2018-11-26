<%@page contentType="text/html;charset=utf-8"%>

		<script type="text/javascript">
 		var idd;
		//页面加载后
		$(function(){
			//表单 查所有
			$("#tableStudent").datagrid({
				url:"${pageContext.request.contextPath}/bz_studentController/selectService.do",
				fitColumns:true,//适应网络宽度 配合 列里面的width
				pagination:true,//打开分页工具
				pageSize:10,
				pageList:[5,10,15,20],
				toolbar:"#pastudent",//引入工具栏
				//删/改超链接  变成-按钮  
				onLoadSuccess:function(date){//数据加载完 执行  参数是远程加载的数据
					console.log(date);
					//$.parser.parse('#cc');  解析参数指定的所有子对象
					//$("a[name=optBtn]").paretn();//通过标签属性值选择器  拿到操作.paretn()方法拿到父
					$.parser.parse($("a[name=optBtn]").parent());
				}
			});
		//初始化添加按钮
			$("#productAddSt").linkbutton({
				//注册事件  打开窗口
				onClick:function(){
					$("#StudentDH").dialog("open");
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
			$("#StudentDH").dialog({
				//设置大小
				width: 400,    
   				height: 300,
   				resizable:true, //设置大小可变
   				title:"添加商品",//设置标题
   				modal:true,//模式化窗口
   				closed:true,//关闭窗口
   				href:"${pageContext.request.contextPath}/add/AddStudent.jsp",
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
 		//学生班级
		function myclazzId(value, row, idx){
			//值 改变成  标签类型
			return row.clazzId.clzName;
 		}
 		//学生就业城市
		function mycityId(value, row, idx){
			//值 改变成  标签类型
			return row.cityId.cityName;
 		}
 		//学生标签
		function mytid(value, row, idx){
			var str="";
			//值 改变成  标签类型（集合）
			for(var i=0;i<row.tid.length;i++){
				 str= str+ row.tid[i].tagName + " ";
			}
			return str;
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
			<table class="table" id="tableStudent">
				<thead>
				<tr class="table_header">
 					<th data-options="field:'xx',width:1,checkbox:true"></th>
					
					<th data-options="field:'stuNname',width:1">
						学生姓名
					</th>
					<th data-options="field:'birthday',width:1">
						出生日期
					</th>
					<th data-options="field:'myclazzId',formatter:myclazzId,width:1">
						学生班级
					</th>
					<th data-options="field:'mycityId',formatter:mycityId,width:1">
						学生就业城市
					</th>
					<th data-options="field:'xxxxx',formatter:mytid,width:1">
						学生标签
					</th>
					
					<th data-options="field:'xxx',formatter:myFormatter">
						操作
					</th>
				</tr>
				</thead>
			</table>
			<!-- 定义工具栏   -->
			<div id="pastudent">
				<a id="pidelete">批量删除</a>
				<!--   添加按钮 -->
				<a id="productAddSt">商品入库</a>	
			</div>
			<!-- 修改-对话框 -->
 			<div id="updateduihua"></div>
 			<!-- 添加-对话框 -->
			<div id="StudentDH"></div>

