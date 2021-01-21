<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/data/get?name=홍길동&num=10">화면에서 서버로 데이터 보내기 name="홍길동", num="10"</a>
	<br>
	서버에서 화면으로 보낸 데이터 <br>
	name : ${name} <br>
	num : ${num }
</body>
</html>