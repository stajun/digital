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
	<div class="container">
	  <h2>게시글 수정</h2>
	  <c:if test="${board != null}">
	  <form action="<%=request.getContextPath()%>/board/modify" method="post" enctype="multipart/form-data">
	  	<div class="form-group">
	      <label for="num">번호</label>
	      <input type="text" class="form-control" id="num" name="num" readonly value="${board.num}">
	    </div>
	    <div class="form-group">
	      <label for="title">제목</label>
	      <input type="text" class="form-control" id="title" name="title" value="${board.title}">
	    </div>
	    <div class="form-group">
	      <label for="writer">작성자</label>
	      <input type="text" class="form-control" id="writer" name="writer" readonly value="${board.writer}">
	    </div>
	    <div class="form-group">
	      <label for="registerDate">작성일</label>
	      <input type="text" class="form-control" id="registerDate" name="registerDate" readonly value="${board.registerDate}">
	    </div>
	    <div class="form-group">
	      <label for="cotent">내용</label>
	      <textarea class="form-control" id="content" name="content">${board.content}</textarea>
	    </div>
	    
	    <div class="form-group">
        <label>파일</label>
        <input type="file" class="form-control" name="fileList"/>
    	</div>
    	<div class="form-group">
        <label>파일</label>
        <input type="file" class="form-control" name="fileList"/>
    	</div>
    	<div class="form-group">
        <label>파일</label>
        <input type="file" class="form-control" name="fileList"/>
    	</div>
	    
	    <c:if test="${fList.size() != 0 }">
	    	<div class="form-group">
		      <label for="cotent">첨부파일</label>
		      <c:forEach items="${fList}" var="file">
		      	<div><a href="<%=request.getContextPath()%>/board/download?fileName=${file.filename}">${file.oriFilename}</a></div>
		      </c:forEach>
		    </div>
	    </c:if>
	    
	    <button type="submit" class="btn btn-outline-info">수정</button>
    </form>
    </c:if>
    <c:if test="${board == null}">
    	<h1>존재하지 않은 게시물입니다.</h1>
    </c:if>
    <a href="<%=request.getContextPath()%>/board/list">
    	<button type="button" class="btn btn-outline-info">목록</button>
    </a>
    <a href="<%=request.getContextPath()%>/board/register">
    	<button type="button" class="btn btn-outline-info">글쓰기</button>
    </a>
	</div>
	<script>
		$(function(){
			$('form').submit(function(){
				var cnt = 0;
				$('input[name=fileList]').each(function(){
					if($(this).val() != ''){
						cnt++;
					}
				})
				if(cnt == 0){
					var res = confirm('선택된 첨부파일이 없습니다. 이전에 등록된 첨부파일이 삭제됩니다. 수정하시겠습니까?');
					return res;
				}
				
				return true;
			})
		})
	</script>
</body>
</html>