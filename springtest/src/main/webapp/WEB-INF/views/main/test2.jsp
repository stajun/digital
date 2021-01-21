<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		학생 이름을 input태그에 입력받아 서버로 전송하여 서버에서 전송된 이름을
		콘솔에 출력하세요. 단, 데이터를 보낼때 변수의 이름을 name으로 설정하세요.
		데이터를 get으로 보내고, 보낼 url은 /test2 
	-->
	<form method="get" action="<%=request.getContextPath()%>/test2">
		<h1>연습1</h1>
		<input type="text" name="name"> <br>
		<button type="submit">전송</button>
	</form>
	<!-- 
		학생 이름과 나이를 input 태그에 입력받아 서버로 전송하여 서버에서 해당
		학생 정보를 출력하세요. 단, 컨트롤러에서 TestVo를 이용하여 출력하세요.
		url은 /test3로, mv.setViewName("/main/test2");로 설정
	 -->
 	<form method="get" action="<%=request.getContextPath()%>/test3">
		<h1>연습2</h1>
		<input type="text" name="name"> <br>
		<input type="text" name="age"> <br>
		<button type="submit">전송</button>
	</form>
	<!--
		 학생 3명의 이름을 input태그에 입력받아 서버로 전송하여 서버에서 해당 학생
		 이름들을 출력하세요. 단, 컨트롤러에서는 학생 이름을 배열로 처리하세요.
		 url은 /test4로, mv.setViewName("/main/test2");로 설정
	 -->
 	<form method="get" action="<%=request.getContextPath()%>/test4">
		<h1>연습3</h1>
		<input type="text" name="name"> <br>
		<input type="text" name="name"> <br>
		<input type="text" name="name"> <br>
		<button type="submit">전송</button>
	</form>
	<!--
		 학생 3명의 이름을 input태그에 입력받아 서버로 전송하여 서버에서 해당 학생
		 이름들을 출력하세요. 단, 컨트롤러에서는 학생 이름들을 하나의 문자열로 처리
		 url은 /test5로, mv.setViewName("/main/test2");로 설정
	 -->
 	<form method="get" action="<%=request.getContextPath()%>/test5">
		<h1>연습4</h1>
		<input type="text" name="name"> <br>
		<input type="text" name="name"> <br>
		<input type="text" name="name"> <br>
		<button type="submit">전송</button>
	</form>
</body>
</html>






