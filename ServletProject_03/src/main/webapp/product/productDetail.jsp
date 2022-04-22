<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>상품 상세보기</h1>
  </div>
</div>

<div class="d-flex container">
<div class="card" style="width:400px">
<img class="card-img-top" src="../upload/${product.filename }" alt="Card image">
</div>
<div class="cotainer">
	<table class="table table-borderless">


      <tr>
        	<td width="200px">상품명(분류)</td>
			<td>${product.pname}(${product.category})</td>
        	
      </tr>
            
		<tr>
        	<td>상품 가격</td>
			<td>${product.unitPrice}</td>		
      </tr>
      <tr>
			<td>상품 설명</td>
			<td>${product.description}</td>			
      </tr>


	</table>
	</div>
	</div>

	
	

<%@ include file="../include/footer.jsp" %>
</html>