<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset= UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function checkSubmit() {
			/*
			//校验 不通过不提交
			 var userName=document.getElementsByName("userName")[0].value;
	        if(userName==null || userName==""){
	            alert("用户名不能为空");
	        	return;
	        }
	        var password=document.getElementsByName("password")[0].value;
	        var rePassword=document.getElementsByName("rePassword")[0].value;
	        if(password!=rePassword){
	            alert("两次输入密码不一致");
	        	return;
	        }
	        */
	       
        document.forms[0].submit();
        }
	</script>
  </head>
 <body>
 	 <a href="${pageContext.request.contextPath}/mid?locale=zh_CN">中文</a><a href="${pageContext.request.contextPath}/mid?locale=en_GB">英文</a>
    <form action="<%=path %>/myreg" method="post"> 
	   	<s:message code="userName"></s:message>:<input type="text" name="userName"/><font color="red"><form:errors path="user.userName"></form:errors></font><br/>  
	   	<s:message code="password"></s:message>&nbsp; :<input type="password" name="password"/><font color="red"><form:errors path="user.password"></form:errors></font><br/>
	   	<s:message code="repassword"></s:message>:<input type="password" name="rePassword"/><font color="red"><form:errors path="user.rePassword"></form:errors></font><br/>  
	   	<s:message code="email"></s:message>&nbsp; :<input type="text" name="email"/><font color="red"><form:errors path="user.email"></form:errors></font><br/>  
	   	<s:message code="age"></s:message>&nbsp; :<input type="text" name="age"/><font color="red"><form:errors path="user.age"></form:errors></font><br/> 
	   	<s:message code="phone"></s:message>:<input type="text" name="phone"/><font color="red"><form:errors path="user.phone"></form:errors></font><br/>
	   	<input type="button" onclick="checkSubmit()" value="<s:message code="reg"></s:message>"/>
     </form><br/>
 </body>
    
</html>
