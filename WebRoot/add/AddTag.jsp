<%@ page pageEncoding="utf-8" %>

	
<script type="text/javascript">
$(function(){
	// 初始化 表单中的 提交按钮
	$("#keepTag").linkbutton({
		iconCls:"icon-ok",//引入图片
		onClick:function(){//注册事件
			$("#AddTagForm").form("submit",{
				url:"${pageContext.request.contextPath}/bz_tagController/insertBz_tag.do",
				onSubmit:function(){//表单验证
					return $("#AddTagForm").form("validate");
				},
				success:function(){//成功后的回调
					$("#tagduihua").dialog("close"),//关闭窗口
					$.messager.show({
					title:"系统提示",
					msg:"添加成功",
					});
					$("#tableTad").datagrid("load");//自动更新表单数据
				}
			});
		}
	});
	
	// 初始化 表单中的 重置按钮
	$("#resettingTag").linkbutton({
		iconCls:"icon-reload",//引入图片
		onClick:function(){//注册事件
			$("#AddTagForm").form("reset");//清除数据
		} 
	});
	//标签名称- 初始化
	$("#tagName").textbox({
		required:true,
		validType:"length[0,10]"
	});
	//标签类型
	$("#tagType").textbox({
		required:true,
		validType:["length[0,1]","minNum"]
	});
	/* $("#tagType").combobox({
		editable:false,//不可编辑
		width:"100px",
	}); */
	
		//自定义 验证规则
	$.extend($.fn.validatebox.defaults.rules, { 
	    //必须是数字
	    minNum:{
	    	//验证规则   
	        validator: function(value){ 
			// isNaN 判断参数是否是数字（true-不是数字,false-是数字）
				return !isNaN(value); 							 
	        }, 
	        message: "必须是数字"  
	    }
	});  
});
</script>
<h3>添加-标签</h3>
<form id="AddTagForm" method="post" >
	<!-- 文本框-标签 -->
	标签名称：<input id="tagName" name="tagName"><br>
	标签类型：<input id="tagType" name="tagType"><br>
	<!-- <select id="tagType" class="easyui-combobox" >
		<option value="1" name="tagType">班级</option>
		<option value="0" name="tagType">学生</option>
	</select> -->
	<br>
	<a id="keepTag">提交</a> 
	<a id="resettingTag">重置</a> 
</form>