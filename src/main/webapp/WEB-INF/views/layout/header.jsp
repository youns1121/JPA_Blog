<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
=======
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var = "principal"/>
</sec:authorize>
>>>>>>> 6a98001 (2021-04-26_스프링 시큐리티 추가)

         <!DOCTYPE html>
         <html lang="en">
         <head>
           <title>Min 블로그</title>
           <meta charset="utf-8">
           <meta name="viewport" content="width=device-width, initial-scale=1">
           <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
           <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
           <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
           <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<<<<<<< HEAD
=======
           <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
           <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
>>>>>>> 6a98001 (2021-04-26_스프링 시큐리티 추가)
         </head>
         <body>

         <nav class="navbar navbar-expand-md bg-dark navbar-dark">
<<<<<<< HEAD
           <a class="navbar-brand" href="/blog/">메인화면</a>
=======
           <a class="navbar-brand" href="/">메인화면</a>
>>>>>>> 6a98001 (2021-04-26_스프링 시큐리티 추가)
           <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
             <span class="navbar-toggler-icon"></span>
           </button>
           <div class="collapse navbar-collapse" id="collapsibleNavbar">
<<<<<<< HEAD
             <ul class="navbar-nav">
               <li class="nav-item">
                 <a class="nav-link" href="/blog/user/loginForm">로그인</a>
               </li>
               <li class="nav-item">
                 <a class="nav-link" href="/blog/user/joinForm">회원가입</a>
               </li>
             </ul>
=======

             <c:choose>
                <c:when test="${empty principal}">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="/auth/loginForm">로그인</a></li>
                        <li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="navbar-nav">
                        <li class="nav-item"><a class="nav-link" href="/board/form">글쓰기</a></li>
                        <li class="nav-item"><a class="nav-link" href="/user/form">회원정보</a></li>
                        <li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>

                    </ul>
                </c:otherwise>
             </c:choose>
>>>>>>> 6a98001 (2021-04-26_스프링 시큐리티 추가)
           </div>
         </nav>
         <br />