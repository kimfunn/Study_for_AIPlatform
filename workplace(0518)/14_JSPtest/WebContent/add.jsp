<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="addException.jsp" %>

	<%
	int num = Integer.parseInt(request.getParameter("num"));
	int sum = 0;
	for(int i=1; i<num; i++){
		sum +=i;
		
	
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 합계 구하기</h2>
	<h2> 1부터 <%= num %> 까지의 합은 <%=sum %>입니다</h2>
</body>
</html>