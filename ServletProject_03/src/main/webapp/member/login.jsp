<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>로그인</h1>
  </div>
  <div class="container">
  <div class="form-group">
				<label for="userid">UserID:</label> <input type="text"
					class="form-control" id="userid" placeholder="Enter userid" name="userid">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter password"
					name="pwd">
			</div>
			<button type="button" class="btn btn-primary" id="loginBtn">로그인</button><!-- 
			<button type="reset" class="btn btn-secondary" >취소</button>
			<button type="button" class="btn btn-secondary" onclick="location.href='memberform.jsp'">회원가입</button>
   --></div>
   <script>
   $("#loginBtn").click(function (){
	   if($("#userid").val()==""){
			alert("아이디 입력");
			$("#userid").focus();
			return false;
		}
		if($("#pwd").val()==""){
			alert("비밀번호 입력");
			$("#pwd").focus();
			return false;
		}
		$.ajax({
			type:"post",
			url : "login",
			data:{"userid" : $("#userid").val(),"pwd" : $("#pwd").val()},
			success: function(resp){
				if(resp.trim()==0){
					alert("일반회원 로그인 ")
					location.href = "../board/boardlist"
				}
				else if(resp.trim()==1){
					alert("관리자 로그인 ")
					location.href = "memberlist";
				}
				else if(resp.trim()==-1){
					alert("회원이 아닙니다.회원가입 하세요.")
					location.href = "join";
				}
				else if(resp.trim()==2){
					alert("비밀번호를 확인하세요")
				}
			},
			error : function (e) {
				alert("error: "+e);
			}
   });
   });
   </script>
   
</div>
<%@ include file="../include/footer.jsp" %>