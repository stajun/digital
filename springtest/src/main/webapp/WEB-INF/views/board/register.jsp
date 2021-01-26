<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<div class="container">
	  <h2>게시글 등록</h2>
	  <form action="<%=request.getContextPath()%>/board/register" method="post" enctype="multipart/form-data">
	    <div class="form-group">
	      <label>제목</label>
	      <input type="text" class="form-control" name="title">
	    </div>
	    <div class="form-group">
	      <label>작성자</label>
	      <input type="text" class="form-control" name="writer" value="${user.id}" readonly>
	    </div>
	    <div class="form-group">
	      <label>내용</label>
	      <textarea style="display:none;" rows="10" class="form-control" name="content"></textarea>
	    </div>
	    <div id="summernote"></div>
	    <div class="form-group">
	      <label>첨부파일</label>
	      <input type="file" class="form-control" name="fileList">
	      <input type="file" class="form-control" name="fileList">
	      <input type="file" class="form-control" name="fileList">
	    </div>
	    <button type="submit" class="btn btn-outline-dark">등록</button>
	  </form>
	  <a href="<%=request.getContextPath()%>/board/list">
			<button type="button" class="btn btn-outline-dark">목록</button>
		</a>
	</div>
	<script>
     $('#summernote').summernote({
       placeholder: 'Hello Bootstrap 4',
       tabsize: 2,
       height: 300
     });
     $('form').submit(function(){
    	 var content = $('#summernote').summernote('code');
    	 $('textarea[name=content]').val(content);
     })
  </script>
</body>
</html>