<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/user/modify" id="form" class="container" method="post">
		<h1 class="title">회원정보 수정</h1>
		<div class="form-group">
			<input type="text" class="form-control" id="id" name="id" placeholder="아이디" value="${user.id}" readonly>
		</div>
		<div class="form-group">
			<input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호"value="">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" id="pw2" name="pw2" placeholder="비밀번호 확인"value="">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="age" name="age" placeholder="나이"value="${user.age}">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="name" name="name" placeholder="이름"value="${user.name}">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="email" name="email" placeholder="이메일" value="${user.email}">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="home" name="home" placeholder="홈페이지" value="${user.home}">
		</div>
		<button class="btn btn-outline-success col-12">회원정보수정</button>
	</form>
	<script>
		$('form').submit(function(){
			var pw = $('input[name=pw]').val();
			var pw2 = $('input[name=pw2]').val();

			if(pw == ''){
				alert('비밀번호를 입력하세요');
				return false;
			}
			
			if(pw != pw2){
				alert('비밀번호가 일치하지 않습니다.')
				return false;
			}
			
			return true;
		})
	</script>
</body>
</html>





