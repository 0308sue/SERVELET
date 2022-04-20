<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script src ="../js/member.js"></script>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>상세보기</h1>
  </div>
</div>

<div class="container ">
		<form action="update" method="post" id="frm">
		<input type="hidden" name="userid" id="userid" value="${member.userid }" />
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" value="${member.name }" name="name">
			</div>

			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" value="${member.pwd }"
					name="pwd">
			</div>
			<div class="form-group">
				<label for="pwd_check">Password_Check:</label> <input
					type="password" class="form-control" id="pwd_check"
					placeholder="Enter password_check" name="pwd_check">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" value="${member.email }"
					name="email">
			</div>
			
			
			<div class="form-group">
				<label for="phone">Phone:</label> <input type="text"
					class="form-control" id="phone"  value="${member.phone }"
					name="phone">
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="radio"
					class="form-check-input" name="admin" value="0" >일반회원
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="radio"
					class="form-check-input" name="admin" value="1">관리자
				</label>
			</div>
			<script>
			if(${member.admin==0}){
				$("input:radio[value=0]").attr("checked",true)
			}else{
				$("input:radio[value=1]").attr("checked",true)
			}
			</script>
			<br><br>
			<button type="submit" class="btn btn-primary" >수정하기</button>
			<button type="reset" class="btn btn-secondary" >취소하기</button>
			<button type="button" class="btn btn-danger" id="">탈퇴하기</button>
		</form>
	</div>

<%@ include file="../include/footer.jsp" %>
</html>