<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script>
$(function(){
	$("#writeBtn").click(function(){
		if(${empty sessionScope.suser}){
			alert("로그인 하세요");
			location.href = "../member/login";
			return;
		}
		location.href = "write";
	})
})
</script>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>게시글 목록(<span id="cntSpan">${count }</span>)</h1>
  </div>
</div>

<div class="container">
<div class="mb-3">
<button type="button" class="btn btn-secondary" id="writeBtn">글쓰기</button>
</div>
	<table class="table table-hover">
    <thead>
      <tr>
        	<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			
      </tr>
	</thead>
	<tbody>
	<c:forEach items="${boards }" var="board">
		<tr>
		<td>${board.num }</td>
    	<td> <a href="boardDetail?num=${board.num}">${board.subject }</a></td>
    	<td>${board.userid }</td>
    	<td>${board.regdate }</td>
    	<td>${board.readcount }</td>
    	</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>

<%@ include file="../include/footer.jsp" %>
</html>