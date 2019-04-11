<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String command = request.getParameter("command");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="<%=basePath%>UpdateOneServlet.action">
    	<tr>
    		<td>指令名称：</td>
    		<td><input type="text" name="command" value="<%=command%>"/></td>
    	</tr>
    	<tr>
    		<td>描述：</td>
    		<td><input type="text" name="description" value=""/></td>
    	</tr>
    	<tr>
    		<td><input type="submit" value="提交"/></td>
    	</tr>
    </form>
  </body>
</html>
