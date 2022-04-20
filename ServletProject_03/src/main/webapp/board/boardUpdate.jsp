<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>board Update</h1>
  </div>
</div>

<div class="container ">
		<form action="update" method="post" id="frm">
		<input type="hidden" name="num" value="${board.num }">
			<div class="form-group">
				<label for="userid">userid:</label> <input type="text"
					class="form-control" id="userid" placeholder="Enter name" 
					name="userid" value="${board.userid }" readonly="readonly">
			</div>

			

			<div class="form-group">
				<label for="subject">subject:</label> <input type="text"
					class="form-control" id="subject" placeholder="Enter password"
					name="subject" value="${board.subject }">
			</div>
			<div class="form-group">
				<label for="pwd_check">Password_Check:</label> <input
					type="password" class="form-control" id="pwd_check"
					placeholder="Enter password_check" name="pwd_check">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" placeholder="Enter email"
					name="email" value="${board.email }">
			</div>
			<div class="form-group">
				<label for="content">Content:</label> 
				<textarea class="form-control" rows="5" name="content" id="content">${board.content }</textarea>
			</div>
			
			<button class="btn btn-primary">수정하기</button>
			<button type="reset" class="btn btn-secondary">취소하기</button>
		</form>
	</div>

<%@ include file="../include/footer.jsp" %>
</html>