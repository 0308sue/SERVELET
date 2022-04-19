<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#send").on("click",function(){
		sendIt();
	})
	$("#dong").keydown(function(e){
		if(e.keyCode == 13){
			sendIt();	
		}
	})
	
	$("#result").on("click","tr",function(){
		var address = $("td:eq(1)",this).text()+" "+
		$("td:eq(2)",this).text()+" "+
		$("td:eq(3)",this).text()+" "+
		$("td:eq(4)",this).text();
		$(opener.document).find("#zipcode").val($("td:eq(0)",this).text());
		$(opener.document).find("#addr").val(address);
		self.close();
	})
})
var sendIt= function(){
if($("#dong").val()==""){
			alert("동이름을 일벽하세요");
			return false
		}
		$.ajax({
			type:"post",
			url:"zip.addr",
			data:{"dong":$("#dong").val()}
		})
		.done(function(resp){
			var str = "<table>"
			$.each(resp,function(key,val){
				str += "<tr>"
					str += "<td>"+val.zipcode+"</td>"
					str += "<td>"+val.sido+"</td>"
					str += "<td>"+val.gugun+"</td>"
					str += "<td>"+val.dong+"</td>"
					str += "<td>"+val.bunji+"</td>"
				str += "</tr>"
			})
			 str += "</table>"
			$("#result").html(str);
		})
		.fail(function(e){
			alert("error:"+e);
		})
}

</script>
</head>
<body>
	<table>
		<tr>
			<td>동이름입력 :<input type="text" name="dong" id="dong">
			<input type="button" value="검색"  id="send">
			</td>
		</tr>
	</table>
	<div id="result"></div>
</body>
</html>