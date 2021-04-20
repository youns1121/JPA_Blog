//package com.ysmin.blog.model;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//
//@Entity // User 클래스가 MySQL에 테이블이 생성됨
//public class User {
//    @Id // pk
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
//
//    private int id; // 시퀀스, auto_increment
//
//    @Column(nullable = false, length = 30) // not null,
//    private String username; // 아이디
//
//    /@
//    private String password;
//
//    private String email;
//
//    private Timestamp createDate; // 날짜
//}
