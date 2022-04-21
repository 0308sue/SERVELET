<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<h2>상품 목록</h2>
		<br> <br>
		<div class="row">
			<c:forEach items="${arr }" var="product">
				<div class="col">
					<div class="card" style="width: 200px">
						<img class="card-img-top" src="../upload/${product.filename }"
							alt="Card image" style="width: 100%" >
						<div class="card-body">
							<h4 class="card-title">상품명 : ${product.pname }</h4>
							<p class="card-text">가격 : ${product.unitPrice }</p>
						</div> <!-- card-body -->
					</div> <!-- card -->
				</div> <!-- col -->
			</c:forEach>
		</div> <!-- row -->

	</div>

</body>
<%@ include file="../include/footer.jsp" %>
</html>