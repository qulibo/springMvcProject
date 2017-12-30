 
 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>食物列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  </head>
  
  <body>
    <!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 菜品列表
			</div>
	    </div>
		<div id="TitleArea_End"></div>
	</div>
	
	
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="${pageContext.request.contextPath}/showFood" method="get">
			<input type="hidden" name="method" value="search">
			<input type="text" name="dname" title="请输入菜品名称">
			<input type="submit" value="搜索">
		</form>
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
	    <table class="MainArea_Content"  cellspacing="0" cellpadding="0">
	        <!-- 表头-->
	        <thead>
	            <tr align="center"  id="TableTitle">
					<td>菜编号</td>
					<td>菜名</td>
					<td>价格</td>
					<td>操作</td>
				</tr>
			</thead>	
			<!--显示数据列表 -->
	        <tbody id="TableData">
			<c:forEach var="tmp" items="${requestScope.foodList.data}">
				<tr class="TableDetail1">
					<td>${pageScope.tmp.foodid }&nbsp;</td>
					<td><a href="${pageContext.request.contextPath}/food/${pageScope.tmp.foodid}">${pageScope.tmp.foodname }&nbsp;</a></td>
					<td>${pageScope.tmp.price }&nbsp;</td>
					<td>
						<a href="${pageContext.request.contextPath}/detail/updateFood.jsp?foodId=${pageScope.tmp.foodid }&foodName=${pageScope.tmp.foodname }&price=${pageScope.tmp.price }&imagepath=${pageScope.tmp.imagepath }"  class="FunctionButton">更新</a>				
						<a href="${pageContext.request.contextPath}/deleteFood/${pageScope.tmp.foodid}" class="FunctionButton">删除</a>				
					</td>
				</tr>
	        </c:forEach>
			<tr><td colspan="6">
          		<a href="${pageContext.request.contextPath}/showFood?curPage=1">首页</a>
          		<a href="${pageContext.request.contextPath}/showFood?curPage=${requestScope.foodList.prePage}">上一页</a>
          
          		<c:forEach var="i" begin="1" end="${requestScope.foodList.totalPage}" step="1">
            	<a href="${pageContext.request.contextPath}/showFood?curPage=${pageScope.i}">${pageScope.i}</a>
          
          		</c:forEach>
          			总共 ${requestScope.foodList.totalCount}条 ， ${requestScope.foodList.totalPage}页
          		<a href="${pageContext.request.contextPath}/showFood?curPage=${requestScope.foodList.nextPage}">下一页</a>
          		<a  href="${pageContext.request.contextPath}/showFood?curPage=${requestScope.foodList.totalPage}">尾页</a>
      		</td></tr>	
	        
	        </tbody>
	    </table>
		
	   <!-- 其他功能超链接 -->
		<div id="TableTail">
			<div class="FunctionButton"><a href="${pageContext.request.contextPath}/detail/saveFood.jsp">添加</a></div>
	    </div> 
	</div>
  </body>
</html>
