<%@ page pageEncoding="utf-8" %>

	
<script type="text/javascript">
$(function(){
	// 初始化 表单中的 提交按钮
	$("#keepCity").linkbutton({
		iconCls:"icon-ok",//引入图片
		onClick:function(){//注册事件
			$("#AddCityForm").form("submit",{
				url:"${pageContext.request.contextPath}/bz_cityController/insertBz_city.do",
				onSubmit:function(){//表单验证
					return $("#AddCityForm").form("validate");
				},
				success:function(){//成功后的回调
					$("#AddCityDH").dialog("close"),//关闭窗口
					$.messager.show({
					title:"系统提示",
					msg:"添加成功",
					});
					$("#tableCity").datagrid("load");//自动更新表单数据
				}
			});
		}
	});
	
	// 初始化 表单中的 重置按钮
	$("#resettingCity").linkbutton({
		iconCls:"icon-reload",//引入图片
		onClick:function(){//注册事件
			$("#AddCityForm").form("reset");//清除数据
		} 
	});
	//姓名- 初始化
	$("#name").textbox({
		required:true,
		validType:"length[0,10]"
	});
});
</script>
<h3>添加-就业城市</h3>
<form id="AddCityForm" method="post" >
	<!-- 文本框-姓名 -->
	城市名称：<input id="cityName" name="cityName"><br>
	<br>
	<a id="keepCity">提交</a> 
	<a id="resettingCity">重置</a> 
</form>