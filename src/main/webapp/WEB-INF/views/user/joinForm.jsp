<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
<<<<<<< HEAD
    <form>
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
=======
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
>>>>>>> 6a98001402c69fa11a917eead30b2635cf8cc5e2
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>