<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import = "java.util.Date,java.io.*"%>  <!-- 디렉티브태그 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
  	현재 시각 : 
  	<% 
  		Date today;
  		out.append(today.toString());
  		today = new Date();
  	%>
  
 	 <%=
 	 today.toString()
 	 %>
  	<%@ include file = "includeTest.jsp" %>
  	
  	<% 
  		FileWriter fw = new FileWriter("test.txt");
		fw.write(today.toString());
		fw.close();		
  	
  	%>
  	<% request.getParameter("age") %>
</body>
</html>