<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
위<br>
	<%

		request.setAttribute("name", "김재민");
		%>	
		<jsp:forward page="elTest2.jsp"></jsp:forward>
</body>
</html>