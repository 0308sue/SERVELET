<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="person.go" method="post">
		name : <input type="text" name="name"> <br> 
		id : <input type="text" name="id"> <br> 
		pwd : <input type="text" name="pwd"> <br> 
		phone : <input type="text" name="phone"> <br> 
		address : <input type="text" name="address"> <br>
		<input type="submit" value="전송">
		<button>버튼전송</button>
	</form>
</body>
</html>