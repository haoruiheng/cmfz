<%@ page pageEncoding="utf-8" %>

	
<script type="text/javascript">
$(function(){
	// 初始化 班级-下拉列表 - 远程加载数据
		$("#clazzId").combobox({
			editable:false,
			url:"${pageContext.request.contextPath }/bz_studentController/selectClazzAll.do",
			textField:"clzName",//显示的
			valueField:"clzId",//value
			onChange:function(newVal){
				//重新加载 市 的下拉列表数据reload 方法
				$("#groupId").combobox("reload","${pageContext.request.contextPath }/bz_studentController/selectGroupAll.do?clazzId="+newVal);
			},//数据加载完之后
			onLoadSuccess:function(data){
				$("#clazzId").combobox("setValue", data[0].clzId);
			}
		});
	//初始化 小组-下拉列表-
		$("#groupId").combobox({
			editable:false,
			textField:"groupName",//显示的
			valueField:"groupId",//valu
		});
	//初始化-学生就业城市
		$("#cityId").combobox({
			editable:false,
			url:"${pageContext.request.contextPath }/bz_studentController/selectCityAll.do",
			textField:"cityName",//显示的
			valueField:"cityId",//value
		});	
	//手动发ajax请求
		$.get("${pageContext.request.contextPath }/bz_studentController/selectTagAll.do?tagType=0",   // 查询所有学生标签  bz_tag where tagType=0
			function(res){  // res是js数组
				// 在学生标签 以复选框的形式 显示
				for(var i=0;i<res.length; i++){  // res[i]--单个tag对象
					$("#stuTags").append(("<input type='checkbox' name='ids' value='"+res[i].tagId+"'/>"+res[i].tagName));
				}
			},
			"json");	
	// 初始化 表单中的 提交按钮
	$("#keepStudent").linkbutton({
		iconCls:"icon-ok",//引入图片
		onClick:function(){//注册事件
			$("#AddStudentForm").form("submit",{
				url:"${pageContext.request.contextPath}/bz_studentController/insertService.do",
				onSubmit:function(){//表单验证
					return $("#AddStudentForm").form("validate");
				},
				success:function(){//成功后的回调
					$("#StudentDH").dialog("close"),//关闭窗口
					$.messager.show({
					title:"系统提示",
					msg:"添加成功",
					});
					$("#tableStudent").datagrid("load");//自动更新表单数据
				}
			});
		}
	});
	
	// 初始化 表单中的 重置按钮
	$("#resettingStudent").linkbutton({
		iconCls:"icon-reload",//引入图片
		onClick:function(){//注册事件
			$("#AddStudentForm").form("reset");//清除数据
		} 
	});
	//学生姓名- 初始化
	$("#stuNname").textbox({
		required:true,
		validType:"length[0,10]"
	});
	//出生日期--初始化
	$("#birthday").textbox({
		required:true,
		validType:["length[0,1]","minNum"]
	});
	//手机号码--初始化
	$("#phone").textbox({
		required:true,
		validType:["length[0,1]","minNum"]
	});
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
<form id="AddStudentForm" method="post" >
	<!-- 文本框-标签 -->
	学生姓名：<input id="stuNname" name="stuNname"><br>
	出生日期：<input id="birthday" name="birthday"><br>
	手机号码：<input id="phone" name="phone"><br>
	学生班级：<input id="clazzId" name="clazzId.clzId"/><br>
	班级小组：<input id="groupId" name="groupId.groupId"/><br>
	就业城市：<input id="cityId" name="cityId.cityId"/><br>
	学生标签： <span id="stuTags"></span>
	<br>
	<a id="keepStudent">提交</a> 
	<a id="resettingStudent">重置</a> 
</form>