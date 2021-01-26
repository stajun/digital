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
	<div class="container">
	  <h2>게시글 상세</h2>
	  <c:if test="${board != null}">
	  <form action="">
	    <div class="form-group">
	      <label>번호</label>
	      <input type="text" class="form-control" name="num" value="${board.num}" readonly>
	    </div>
	    <div class="form-group">
	      <label>제목</label>
	      <input type="text" class="form-control" name="title" value="${board.title}" readonly>
	    </div>
	    <div class="form-group">
	      <label>작성자</label>
	      <input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
	    </div>
	    <div class="form-group">
	      <label>작성일</label>
	      <input type="text" class="form-control" name="registerDate" value="${board.registerDate}" readonly>
	    </div>
	    <div class="form-group">
	      <label>조회수</label>
	      <input type="text" class="form-control" name="views" value="${board.views}" readonly>
	    </div>
	    <button type="button" class="btn btn-<c:if test="${like == null || like.up != 1}">outline-</c:if>dark up">추천</button>
	    <button type="button" class="btn btn-<c:if test="${like == null || like.up != -1}">outline-</c:if>dark down">비추천</button>
	    <div class="form-group">
	      <label>내용</label>
	      <div>${board.content}</div>
	    </div>
	    <c:if test="${fList.size() != 0}">
		    <div class="form-group">
		    	<label>첨부파일</label>
		    	<c:forEach items="${fList}" var="file">	
		    	<div><a href="<%=request.getContextPath()%>/board/download?filename=${file.filename}">${file.oriFilename}</a></div>
		    	</c:forEach>
		    </div>
	    </c:if>
	  </form>
	  </c:if>
	  <c:if test="${board == null}">
	  <h1>존재하지 않은 게시글입니다.</h1>
	  </c:if>
	</div>
	<a href="<%=request.getContextPath()%>/board/list?page=${cri.page}&type=${cri.type}&search=${cri.search}">
		<button type="button" class="btn btn-outline-dark">목록</button>
	</a>
	<a href="<%=request.getContextPath()%>/board/register">
		<button type="button" class="btn btn-outline-dark">글쓰기</button>
	</a>
	<c:if test="${user != null && user.id == board.writer}">
	<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}">
		<button type="button" class="btn btn-outline-dark">수정</button>
	</a>
	<a href="<%=request.getContextPath()%>/board/delete?num=${board.num}">
		<button type="button" class="btn btn-outline-dark">삭제</button>
	</a>
	</c:if>
	<script>	
		var up = '${like.up}';
		$('.btn.up, .btn.down').click(function(){
			//추천버튼을 클릭하면
			if($(this).hasClass('up')){
				//추천상태에서 추천버튼을 클릭하면
				if(up == 1)
					up = 0;
				//추천상태가 아닌상황에서 추천버튼을 클릭하면
				else
					up = 1;
			}
			//비추천버튼을 클릭하면
			else{
				//비추천상태에서 비추천버튼을 클릭하면
				if(up == -1)
					up = 0;
				//비추천상태가 아닌 상황에서 비추천버튼을 클릭하면
				else
					up = -1;
			}
			//추천/비추천인 경우
			if(up != 0){
				/*
				추천/비추천버튼 모두에 btn-dark클래스 제거, 
    		btn-outline-dark클래스 추가
				*/
				$('.btn.up, .btn.down').removeClass('btn-dark')
															.addClass('btn-outline-dark');
				//클릭한 버튼에 btn-dark클래스 추가, btn-outline-dark클래스제거
				$(this).addClass('btn-dark').removeClass('btn-outline-dark');
			}
			//추천/비추천을 취소한 경우
			else{
				//클릭한 버튼에 btn-dark클래스 제거, btn-outline-dark클래스추가    
				$(this).removeClass('btn-dark').addClass('btn-outline-dark');
			}
			
			
			
			var id = '${user.id}';
			if(id == ''){
				alert('추천/비추천 기능은 로그인해야합니다.');
				return;
			}
			
			var boardNum = $('input[name=num]').val();
			var data = { 'id' : id, 'boardNum' : boardNum, 'up':up};
			
			var obj = $(this);
			
			$.ajax({
        type:'POST',
        data: data,
        url:'<%=request.getContextPath()%>/board/like',
        success : function(data){
					if(up == 1){
						alert('추천했습니다.')
					}else if(up == -1){
						alert('비추천했습니다.')
					}else{
						//클릭된 버튼이 추천이면 추천이 취소되었습니다
						if(obj.hasClass('up'))
							alert('추천이 취소되었습니다');
						//아니면 비추천이 취소되었습니다.
						else
							alert('비추천이 취소되었습니다');
					}
        }
	    })
		})
	</script>
</body>
</html>