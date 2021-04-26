<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
<form action="/action_page.php">
  <div class="form-group">
    <label for="username">Username</label>
    <input type="text" class="form-control" placeholder="Enter username" id="username">
  </div>

  <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" placeholder="Enter password" id="password">
  </div>

  <div class="form-group">
      <label for="email">Email</label>
      <input type="email" class="form-control" placeholder="Enter email" id="email">
  </div>

</form>
  <button id="btn-save" class="btn btn-primary">회원가입완료</button>
</div>

<<<<<<< HEAD
<script src="/blog/js/user.js"></script>
=======
<script src="/js/user.js"></script>
>>>>>>> 6a98001 (2021-04-26_스프링 시큐리티 추가)
<%@ include file="../layout/footer.jsp" %>