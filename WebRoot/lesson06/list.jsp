<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	

	<body>
		<input type='text' name="foodName" />
		<input type='button' value="查询" onclick="query()">
		<table id="myTable">  
           <tr><th>菜品名</th><th>菜品价格</th></tr>
		</table>
	</body>
</html><head>
		<base href="<%=basePath%>">

		<title>My JSP 'list.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
function query() {
	//无刷新调用 http://localhost:8080/s/queryFood 获取到数据 数据通过dom方式添加到 table中
	//ajax(异步的ajax)+json
	var xmlhttp=null;
	//兼容所有的瀏覽器創建這個對象 XHR對象
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	//回調函數 當請求發送后 收到結果自動調用該方法
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		    //返回的是字符串的json
			var resutlJson = xmlhttp.responseText;
			//轉換為js對象
			var resultObj=JSON.parse(resutlJson);
			//获取表格对象
			var table=document.getElementById("myTable");
			//将所有名字为 dataTr的tr全部删除  [a,b,c]
			var allDataTr=document.getElementsByName("dataTr");
			var length=allDataTr.length;
			for(var i=0;i<length;i++){
			  table.removeChild(allDataTr[0]);
			}
			
			//根据json的行数追加多个tr
			for(var i=0;i<resultObj.length;i++){
			   var obj=resultObj[i];
			   var td=document.createElement("td");
			   td.innerText=obj.foodname;
			   var td1=document.createElement("td");
			   td1.innerText=obj.price;
			   var tr=document.createElement("tr");
			   tr.setAttribute("name","dataTr");
			   tr.appendChild(td);
			   tr.appendChild(td1);
			   table.appendChild(tr);
			}
			
		}
	}
	var foodname=document.getElementsByName("foodName")[0].value;
	//open方法表示 產生一個請求的關聯  (get 提交 )
	 ("GET", "${pageContext.request.contextPath}/queryFood?foodname="+foodname, true);
	xmlhttp.send();
}
</script>
	</head>
