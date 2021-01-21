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
	  <h2>게시글 상세</h2>
	  <c:if test="${board != null}">
  	<div class="form-group">
      <label for="num">번호</label>
      <input type="text" class="form-control" id="num" name="num" readonly value="${board.num}">
    </div>
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" class="form-control" id="title" name="title" readonly value="${board.title}">
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
      <label for="views">조회수</label>
      <input type="text" class="form-control" id="views" name="views" readonly value="${board.views}">
    </div>
    <div class="form-group">
    	<button type="button" class="btn btn-<c:if test="${like == null || like.up != 1}">outline-</c:if>success up">추천</button>
    	<button type="button" class="btn btn-<c:if test="${like == null || like.up != -1}">outline-</c:if>success down">비추천</button>
    </div>
    <div class="form-group">
      <label for="cotent">내용</label>
      <div>${board.content}</div>
    </div>
    
    <c:if test="${fList.size() != 0 }">
    	<div class="form-group">
	      <label for="cotent">첨부파일</label>
	      <c:forEach items="${fList}" var="file">
	      	<div><a href="<%=request.getContextPath()%>/board/download?fileName=${file.filename}">${file.oriFilename}</a></div>
	      </c:forEach>
	    </div>
    </c:if>
    
    </c:if>
    <c:if test="${board == null}">
    	<h1>존재하지 않은 게시물입니다.</h1>
    </c:if>
    <a href="<%=request.getContextPath()%>/board/list?page=${cri.page}&search=${cri.search}&type=${cri.type}">
    	<button type="button" class="btn btn-outline-info">목록</button>
    </a>
    <a href="<%=request.getContextPath()%>/board/register">
    	<button type="button" class="btn btn-outline-info">글쓰기</button>
    </a>
    <c:if test="${user != null && user.id == board.writer }">
    <a href="<%=request.getContextPath()%>/board/modify?num=${board.num}">
    	<button type="button" class="btn btn-outline-info">수정</button>
    </a>
    <a href="<%=request.getContextPath()%>/board/delete?num=${board.num}">
    	<button type="button" class="btn btn-outline-info">삭제</button>
    </a>
    </c:if>
	</div>
	<script type="text/javascript">
		$('.btn.up, .btn.down').click(function(){
			var id = '${user.id}';
			if(id == ''){
				alert('회원만 추천/비추천이 가능합니다.')
				return;
			}
			var boardNum = $('input[name=num]').val();
			var up = 0; //1 or 0 or -1
			//추천 버튼을 클릭하면
			if($(this).hasClass('up')){
				//이미 추천된 게시글을 다시 추천버튼을 눌렀을 때
				//추천을 해제하는 경우
				if($(this).hasClass('btn-success')){
					up = 0;
				}
				else{
					up = 1;	
				}
			}
			//비추천 버튼을 클릭하면
			else{
				if($(this).hasClass('btn-success')){
					up = 0;
				}
				else{
					up = -1;	
				}
			}
			var obj = $(this);
			var sendData = {'id' : id, 'boardNum' : boardNum, 'up' : up };
			$.ajax({
				url : '<%=request.getContextPath()%>/board/like',
				type : 'post',
				data : JSON.stringify(sendData),
				dataType:"json",
        contentType:"application/json; charset=UTF-8",
				success : function(data){
					if(up == 0){
						if(obj.hasClass('up')){
							//alert('추천을 취소했습니다.');
						}else{
							//alert('비추천을 취소했습니다.');
						}
						obj.removeClass('btn-success')
						.addClass('btn-outline-success');
					}
					else if(up == 1){
						//alert('추천했습니다.')
						$('.btn.up, .btn.down').removeClass('btn-success')
							.addClass('btn-outline-success');
						obj.removeClass('btn-outline-success')
						.addClass('btn-success');
					}else if(up == -1){
						//alert('비추천했습니다.');
						$('.btn.up, .btn.down').removeClass('btn-success')
							.addClass('btn-outline-success');
						obj.removeClass('btn-outline-success')
						.addClass('btn-success');
					}
				},
				error : function(){
					console.log('추천/비추천 과정에 문제가 있습니다.')
				}
			})
			
		})
	</script>
</body>
</html>