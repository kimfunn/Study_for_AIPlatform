<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<td><b>아이디</b></td>
			<td><b>비밀번호</b></td>
			<td><b>이름</b></td>
		</tr>
		<c:forEach items="${membersList }" var="m" > <!--  태그 라이브러리
		 https://atoz-develop.tistory.com/entry/JSP-JSTL-%EC%82%AC%EC%9A%A9-%EB%B0%A9%EB%B2%95-%EC%A3%BC%EC%9A%94-%ED%83%9C%EA%B7%B8-%EB%AC%B8%EB%B2%95-%EC%A0%95%EB%A6%AC
		 --> 
		 	<tr align="center">
		 		<td>${m.id }</td>
		 		<td>${m.pw }</td>
		 		<td>${m.name }</td>
		 	</tr>
		 </c:forEach>
		
	</table>
</body>
</html>