<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">HOME</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/ServletProject_03/board/boardlist">게시판</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="#">상품보기</a>
    </li>
    
    <c:if test="${empty sessionScope.suser }">
    <li class="nav-item">
      <a class="nav-link" href="/ServletProject_03/member/join">회원가입</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/ServletProject_03/member/login">로그인</a>
    </li>
    </c:if>
    <c:if test="${not empty sessionScope.suser }">
    <li class="nav-item">
      <a class="nav-link" href="/ServletProject_03/member/logout">로그아웃</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/ServletProject_03/member/update">회원변경</a>
    </li>
    </c:if>
  </ul>

</nav>
