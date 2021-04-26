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
=======
<form action ="#" method="post">
  <div class="form-group">
    <label for="username">Username</label>
    <input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
  </div>


  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
>>>>>>> 6a98001 (2021-04-26_스프링 시큐리티 추가)
  </div>

  <div class="form-group form-check">
    <label class="form-check-label">
<<<<<<< HEAD
      <input class="form-check-input" type="checkbox"> Remember me
    </label>
  </div>
  <button type="submit" class="btn btn-primary">로그인</button>
</form>

=======
      <input name="remember" class="form-check-input" type="checkbox"> Remember me
    </label>
  </div>
  <button id="btn-login" class="btn btn-primary">로그인</button>
</form>


>>>>>>> 6a98001 (2021-04-26_스프링 시큐리티 추가)
</div>

<%@ include file="../layout/footer.jsp" %>