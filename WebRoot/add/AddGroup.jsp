<%@ page pageEncoding="utf-8" %>

	
<script type="text/javascript">
$(function(){
	//页面加载后发ajax请求查班级
	$("#clazz1").combobox({
		editable:false,
		url:"${pageContext.request.contextPath }/bz_groupController/selectClassAll.do",
		textField:"clzName",//显示的
		valueField:"clzId",//value
		onChange:function(newVal){
			//成功后执行
		}
	});

	// 初始化 表单中的 提交按钮
	$("#keepGroup").linkbutton({
		iconCls:"icon-ok",//引入图片
		onClick:function(){//注册事件
			$("#AddGroupForm").form("submit",{
				url:"${pageContext.request.contextPath}/bz_groupController/insertGroup.do",
				onSubmit:function(){//表单验证
					return $("#AddGroupForm").form("validate");
				},
				success:function(){//成功后的回调
					$("#AddGroupDH").dialog("close"),//关闭窗口
					$.messager.show({
					title:"系统提示",
					msg:"添加成功",
					});
					$("#tableGroup").datagrid("load");//自动更新表单数据
				}
			});
		}
	});
	
	// 初始化 表单中的 重置按钮
	$("#resettingGroup").linkbutton({
		iconCls:"icon-reload",//引入图片
		onClick:function(){//注册事件
			$("#AddGroupForm").form("reset");//清除数据
		} 
	});
	//小组名称- 初始化
	$("#groupName").textbox({
		required:true,
		validType:"length[0,10]"
	});
});
</script>
<h3>添加-小组信息</h3>
<form id="AddGroupForm" method="post" >
	<!-- 文本框-小组 -->
	小组名称：<input id="groupName" name="groupName"><br>
	班级：<input id="clazz1">
	<br>
	<a id="keepGroup">提交</a> 
	<a id="resettingGroup">重置</a> 
</form>