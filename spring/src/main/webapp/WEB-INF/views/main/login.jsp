<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${user == null}">
	<!-- url이 localhost:8080/test/login -->
	<form action="<%=request.getContextPath()%>/login" method="post">
    <div class="form-group">
      <label for="usr">ID:</label>
      <input type="text" class="form-control" id="usr" name="id">
    </div>
    <div class="form-group">
      <label for="pwd">PW:</label>
      <input type="password" class="form-control" id="pwd" name="pw">
    </div>
    <button type="submit" class="btn btn-primary col-12">로그인</button>
  </form>
  </c:if>
  <c:if test="${user != null}">
  	<button id="btnAjax1">ajax 버튼1</button>
  	<button id="btnAjax2">ajax 버튼2</button>
  	
  	<div>
  		<table class="table table-hover">
				<thead>
					<tr>
						<td>아이디</td>
						<td>이름</td>
						<td>이메일</td>
						<td>나이</td>
						<td>홈페이지</td>
						<td>권한</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>임시1</td>
						<td>임시1</td>
						<td>임시1</td>
						<td>임시1</td>
						<td>임시1</td>
						<td>임시1</td>
					</tr>
					<tr>
						<td>임시2</td>
						<td>임시2</td>
						<td>임시2</td>
						<td>임시2</td>
						<td>임시2</td>
						<td>임시2</td>
					</tr>
				</tbody>
			</table>
  	</div>
  	<script>
  		$(function(){
  			$('#btnAjax1').click(function(){
  				var data = { name : 'Hong', age : 21 };
  				$.ajax({
  					url : '<%=request.getContextPath()%>/ajax1',
  					type : 'post',
  					data : data,
  					success : function(data){
  						console.log(data);
  					},
  					error : function(){
  						console.log('실패');
  					}
  				})
  			})
  		})
  	</script>
  	<script type="text/javascript">
  	$('#btnAjax2').click(function(){
			var sendData = { name : 'Hong', age : 21 };
			$.ajax({
				url : '<%=request.getContextPath()%>/ajax2',
				type : 'post',
				data : JSON.stringify(sendData),
				dataType:"json",
        contentType:"application/json; charset=UTF-8",
				success : function(data){
					var str = '';
					
					var list = data['list'];
					for(var i = 0; i<list.length; i++){
						str += '<tr>'
						str += '<td>'+list[i]['id']+'</td>'
						str += '<td>'+list[i]['name']+'</td>'
						str += '<td>'+list[i]['email']+'</td>'
						str += '<td>'+list[i]['age']+'</td>'
						str += '<td>'+list[i]['home']+'</td>'
						str += '<td>'+list[i]['author']+'</td>'
						str += '</tr>'
					}
					$('tbody').html(str);
					
					console.log(data);
					console.log(data['list'][0]['email']);
					console.log(data.list[0].email);
					console.log(data.testVo.name)
					console.log(data['testVo']['name'])
				},
				error : function(){
					console.log('실패');
				}
			})
		})
  	</script>
  </c:if>
  <script type="text/javascript" 
  src="<%=request.getContextPath()%>/resources/js/test.js"></script>
</body>
</html>




