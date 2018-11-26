<%@ page pageEncoding="utf-8" %>
<html>
	<head>
		<title>布局</title>
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUI/themes/default/easyui.css">
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUI/themes/icon.css">
			<script type="text/javascript" src="${pageContext.request.contextPath}/easyUI/jquery.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/easyUI/jquery.easyui.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/easyUI/easyui-lang-zh_CN.js"></script>
			<script type="text/javascript">
			
			</script>
	</head>
	
	<body class="easyui-layout">   
		<!-- 上，标题，可否移动 ，大小样式  background:#eee; 背景颜色-->
	    <div data-options="region:'north',title:'上',split:true,href:'${pageContext.request.contextPath }/north.jsp'" style="height:100px;">上</div>   
	    <div data-options="region:'west',title:'左',split:true,href:'${pageContext.request.contextPath }/west.jsp'" style="width:200px;">左</div>   
	    <div data-options="region:'center',title:'中',href:'${pageContext.request.contextPath }/center.jsp' " style="padding:5px;background:#eee;"></div>   
		
		
	</body>
</html>