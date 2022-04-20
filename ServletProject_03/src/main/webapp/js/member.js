

$(document).ready(function(){
	var exp =/^[0-9]{3}-[0-9]{4}-[0-9]{4}$/
	$("#sendBtn").click(function(){
		if($("#name").val()==""){
			alert("이름을 입력하세요");
			$("#name").focus();
			return false;
		}
		if($("#userid").val()==""){
			alert("아이디를 입력하세요");
			$("#userid").focus();
			return false;
		}
		if($("#pwd").val()==""){
			alert("비밀번호를 입력하세요");
			$("#pwd").focus();
			return false;
		}
		if($("#pwd").val()!=$("#pwd_check").val()){
			alert("비밀번호가 일치하지 않습니다");
			$("#pwd_check").focus();
			return false;
		}
		if($("#email").val()==""){
			alert("이메일을 입력하세요");
			$("#email").focus();
			return false;
		}
		
		if(!exp.test($("#phone").val())){
			alert("전화번호 형식이 아닙니다")
			$("#phone").focus();
			return false;
		}
		$("#frm").submit();
		});
		
		//아이디 중복확인 창
		$("#idCheckBtn").click(function(){
			window.open("idCheck","","width=600 height = 300")
		})
		
		$("#useBtn").click(function(){
			if($("#userid").val()==""){
				alert("아이디 입력");
				$("#userid").focus();
				return;
		}
		$.ajax({
		type:"post",
				url:"idCheck",
				data:{"userid":$("#userid").val()},
				success:function(resp){
					if(resp.trim()=="yes"){
						alert("사용가능한 아이디 입니다.")
						$(opener.document).find("#userid").val($("#userid").val());
						self.close();
					}else{
						alert("사용 불가능한 아이디 입니다.")
						$("#userid").val("");
						$("#userid").focus();
					}
				}	
		})
		})
		});
		
			function del(userid){
		
		if(confirm("삭제할까요?")){
			$.getJSON("userDelete",
						{"userid":userid},
						function(resp){
							//alert(resp);	
						var str ="";
						$.each(resp.jarr,function(key,val){
							str +="<tr>"
							str += "<td>"+val.name+"</td>"
							str += "<td>"+val.userid+"</td>"
							str += "<td>"+val.phone+"</td>"
							str += "<td>"+val.email+"</td>"
							if(val.admin == 0){
								str += "<td>일반회원</td>"
								str += "<td onclick=del('"+val.userid+"')>삭제</td>"
							}
							else{
								str += "<td>관리자</td>"
								str += "<td>Admin1</td>"
							}
							str +="</tr>"
						})
						$("table tbody").html(str);
						$("#cntSpan").text(resp.count)
						})
			
		}//if
	} //del
