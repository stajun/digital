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
	  <h2>게시글 수정</h2>
	  <c:if test="${board != null && board.writer == user.id }">
	  <form action="<%=request.getContextPath()%>/board/modify" method="post" enctype="multipart/form-data">
	    <input type="hidden" name="num" value="${board.num }">
	    <div class="form-group">
	      <label>번호</label>
	      <input type="text" class="form-control" name="num" value="${board.num}" readonly>
	    </div>
	    <div class="form-group">
	      <label>제목</label>
	      <input type="text" class="form-control" name="title" value="${board.title}">
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
	      <label>내용</label>
	      <textarea rows="10" class="form-control" name="content">${board.content}</textarea>
	    </div>
	    <div class="form-group">
	      <label>첨부파일</label>
	      <input type="file" class="form-control" name="fileList">
	      <input type="file" class="form-control" name="fileList">
	      <input type="file" class="form-control" name="fileList">
	    </div>
	    <c:if test="${fileList.size() != 0}">
		    <div class="form-group">
		    	<label>기존 첨부파일</label>
		    	<c:forEach items="${fileList}" var="file">	
		    	<div><a href="<%=request.getContextPath()%>/board/download?filename=${file.filename}">${file.oriFilename}</a></div>
		    	</c:forEach>
		    </div>
	    </c:if>
	    <button type="submit" class="btn btn-outline-dark">수정</button>
	  </form>
	  </c:if>
	  <c:if test="${board == null || board.writer != user.id }">
	  	<h1>존재하지 않은 게시글이거나 작성자가 아닙니다.</h1>
	  </c:if>
	</div>
	<a href="<%=request.getContextPath()%>/board/list">
		<button type="button" class="btn btn-outline-dark">목록</button>
	</a>
	<a href="<%=request.getContextPath()%>/board/register">
		<button type="button" class="btn btn-outline-dark">글쓰기</button>
	</a>
	<script type="text/javascript">
		$(function(){
			/* 
			- submit()은 return값이 true이면 submit을 진행하고, false이면
				진행하지 않는다. 즉, return이 true이면 서버로 데이터를 전송하고,
				false이면 서버로 데이터를 전송하지 않는다.
			*/
			$('form').submit(function(){
				/* 첨부파일의 파일명을 가져와서 콘솔에 출력하는 코드 */
				/*
				var test1 = $('input[name=fileList]').eq(0).val();
				var test2 = $('input[name=fileList]').eq(1).val();
				var test3 = $('input[name=fileList]').eq(2).val();
				console.log('첫번째 파일 : ' + test1);
				console.log('두번째 파일 : ' + test2);
				console.log('세번째 파일 : ' + test3);
				*/
				/* 파일명이 빈 문자열인 ''와 같지 않으면(추가된 첨부파일이 있으면)
					 갯수를 증가 */
				var cnt = 0;
				$('input[name=fileList]').each(function(){
					var fileName = $(this).val()
					if(fileName != ''){
						cnt++;
					}
				})
				if(cnt == 0){
					return confirm('선택된 첨부파일이 없습니다. 수정하시겠습니까?');					
				}
				return true;
			});
		})
	</script>
</body>
</html>