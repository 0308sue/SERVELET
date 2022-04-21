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
	<c:forEach items="${boards }" var="board" varStatus="st">
		<tr>
		<td>${rowNo-st.index}</td>
    	<td> <a href="boardDetail?num=${board.num}">${board.subject }</a></td>
    	<td>${board.userid }</td>
    	<td>${board.regdate }</td>
    	<td>${board.readcount }</td>
    	</tr>
	</c:forEach>
	</tbody>
	</table>
	 <ul class="pagination">
	 <c:if test="${p.startPage > p.blockPage}">
    <li class="page-item"><a class="page-link" 
    href="boardlist?pageNum=${p.startPage-p.blockPage} }&field=${p.field }&word=${p.word }">Previous</a></li>
    </c:if>
    
    <c:forEach begin="${p.startPage }" end="${p.endPage }" var="i">
    <c:if test="${p.currentPage!=i}">
    <li class="page-item"><a class="page-link" href="boardlist?pageNum=${i}&field=${p.field }&word=${p.word }">${i }</a></li>
    </c:if>
    <c:if test="${p.currentPage==i}">
    <li class="page-item active"><a class="page-link" href="#">${i }</a></li>
     </c:if>
    </c:forEach>
    
    <c:if test="${p.endPage < p.totPage}">
    <li class="page-item">
    <a class="page-link" href="boardlist?pageNum=${p.endPag+1 }&field=${p.field }&word=${p.word }">Next</a></li>
         </c:if>
  </ul>
  <form action="boardlist" class="form-inline">
    <div class="form-group">
      
      <select class="form-control" id="field" name="sellist1">
        <option value="subject">제목</option>
        <option value="content">내용</option>
        <option value="userid">작성자</option>
      </select>
    
				<textarea class="form-control" rows="1" name="word" id="word" placeholder="search"></textarea>

      <br>
      
    </div>
    <button type="submit" class="btn btn-success">search</button>
  </form>
	</div>

<%@ include file="../include/footer.jsp" %>
</html>