<%@page contentType="text/html;charset=utf-8"%>

		<script type="text/javascript">
 		var idd;
		//页面加载后
		$(function(){
			//表单 查所有
			$("#tableCity").datagrid({
				url:"${pageContext.request.contextPath}/bz_cityController/selectAll.do",
				fitColumns:true,//适应网络宽度 配合 列里面的width
				pagination:true,//打开分页工具
				pageSize:5,
				pageList:[5,10,15,20],
				toolbar:"#pacity",//引入工具栏
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
					$("#AddCityDH").dialog("open");
				},
			});
			//初始化-添加对话框
			$("#AddCityDH").dialog({
				//设置大小
				width: 400,    
   				height: 300,
   				resizable:true, //设置大小可变
   				title:"添加商品",//设置标题
   				modal:true,//模式化窗口
   				closed:true,//关闭窗口
   				href:"${pageContext.request.contextPath}/add/AddCity.jsp",
   				cache:false//清除缓存
   				
			});
			
			
		});
		//操作的  修改/删除功能
		function myFormatter(value, row, idx){
			return "<a  class='l-btn' href='javascript:void(0)' onclick='deletep("+row.id+")'>删除</a>";
 		}
 		//分组
		 function fenzu(value, row, idx){
			return row.cate_id.categoryname;
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
			<table class="table" id="tableCity">
				<thead>
				<tr class="table_header">
 					<th data-options="field:'xx',width:1,checkbox:true"></th>
					
					<th data-options="field:'cityName',width:1">
						就业城市
					</th>
					<th data-options="field:'createTime',width:1">
						创建时间
					</th>
					<th data-options="field:'xxx',formatter:myFormatter">
						操作
					</th>
				</tr>
				</thead>
			</table>
			<!-- 定义工具栏   -->
			<div id="pacity">
				<!--   添加按钮 -->
				<a id="productAdd">添加城市</a>	
			</div>
 			<!-- 添加-对话框 -->
			<div id="AddCityDH"></div>

