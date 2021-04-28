<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="layout/header.jsp" %>

<div class="container">

<c:forEach var = "board" items="${boards}">
    <div class="card m-2">
      <div class="card-body">
        <h4 class="card-title">${board.title}</h4>
        <a href="#" class="btn btn-primary">상세보기</a>
      </div>
    </div>

</c:forEach>
</div>


<script src="/js/user.js"></script>
<%@ include file="layout/footer.jsp" %>