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
	<!-- url이 localhost:8080/test/login -->
	<form action="<%=request.getContextPath()%>/login" method="post">
    <div class="form-group">
      <label for="usr">ID:</label>
      <input type="text" class="form-control" id="usr" name="username">
    </div>
    <div class="form-group">
      <label for="pwd">PW:</label>
      <input type="password" class="form-control" id="pwd" name="password">
    </div>
    <button type="submit" class="btn btn-primary col-12">로그인</button>
  </form>
  <a href="#" class="find-pw">비밀번호 찾기</a>
  <script>
  	
  	$('.find-pw').click(function(e){
  		e.preventDefault();
  		
  		var id = prompt('아이디를 입력하세요');
  		
 	  	var data = { 'id' : id};
 	  	
  		$.ajax({
        type:'POST',
        data: data,
        url:'<%=request.getContextPath()%>/find/pw',
        success : function(data){
					if(data == "fail")
						alert('존재하지 않은 아이디입니다');
					else
						alert('비밀번호를 등록한 메일로 전송했습니다');
        }
	    })
  	})
  </script>
</body>
</html>









