<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>상품등록</h1>
    </div>
</div>

<div class="container">
		<form action="pInsert" method="post" enctype="multipart/form-data">
			<div class="form-group  row">
				<label class="col-sm-2"  for=name>name</label>
				<div class="col-sm-3">
				 	<input type="text" 	class="form-control" id="name" name="name" >
				 </div>
			</div>
			<div class="form-group  row">
				<label class="col-sm-2"  for=unitPrice>unitPrice</label>
				<div class="col-sm-3">
				 	<input type="text" 	class="form-control" id="unitPrice" name="unitPrice" >
				 </div>
			</div>
			<div class="form-group  row">
				<label class="col-sm-2"  for=description>description</label>
				<div class="col-sm-5">
				 	<textarea 	class="form-control"  cols="50" rows="2" name="description" ></textarea>
				 </div>
			</div>
			<div class="form-group  row">
				<label class="col-sm-2"  for=manufacturer>manufacturer</label>
				<div class="col-sm-3">
				 	<input type="text" 	class="form-control" id=manufacturer name="manufacturer" >
				 </div>
			</div>
			<div class="form-group  row">
				<label class="col-sm-2"  for=category>category</label>
				<div class="col-sm-3">
				 	<input type="text" 	class="form-control" id="category" name="category" >
				 </div>
			</div>
		<div class="form-group row">
				<label class="col-sm-2">unitsInStock</label>
				<div class="col-sm-3">
					<input type="text" id="unitsInStock" name="unitsInStock" class="form-control" >
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">condition</label>
				<div class="form-check-inline">
					<label class="form-check-label">
					 <input type="radio"  class="form-check-input" name="condition" value="New" 
					 checked>New
					</label>
				</div>
			<div class="form-check-inline">
				<label class="form-check-label">
				 <input type="radio"  class="form-check-input" name="condition" value="Old">Old
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label">
				 <input type="radio"  class="form-check-input" name="condition" value="Refurbished">Refurbished
				</label>
			</div>
	   </div>
		<div class="form-group row">
				<label class="col-sm-2">file</label>
				<div class="col-sm-5">
					<input type="file" name="productImage" class="form-control" id="productImage">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10 ">
					<input type="submit" class="btn btn-primary"  value="상품추가">
				</div>
			</div>
		</form>
	</div>

<%@ include file="../include/footer.jsp" %>