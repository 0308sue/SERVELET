<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>board write</h1>
  </div>
</div>

<div class="container ">
		<form action="write" method="post" id="frm">

			<div class="form-group">
				<label for="userid">userid:</label> <input type="text"
					class="form-control" id="userid" name="userid"
					readonly="readonly" value="${sessionScope.suser.userid}">
			</div>

			

			<div class="form-group">
				<label for="subject">subject:</label> <input type="text"
					class="form-control" id="subject" placeholder="Enter password"
					name="subject">
			</div>
			<div class="form-group">
				<label for="pwd_check">Password_Check:</label> <input
					type="password" class="form-control" id="pwd_check"
					placeholder="Enter password_check" name="pwd_check">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" placeholder="Enter email"
					name="email">
			</div>
			<div class="form-group">
				<label for="content">Content:</label> 
				<textarea class="form-control" rows="5" name="content" id="content"></textarea>
			</div>
			
			<button class="btn btn-primary">글쓰기</button>
		</form>
	</div>

<%@ include file="../include/footer.jsp" %>
</html>