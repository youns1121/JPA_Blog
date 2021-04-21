package com.ysmin.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;




@Data // Getter, Setter
@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 생성자
@Builder //빌더 패턴!!
//User 클래스가 MySQL에 테이블이 생성됨
//ORM -> JAVA(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity
public class User {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
    private int id; // 시퀀스, auto_increment

    @Column(nullable = false, length = 30) // not null, 길이는 30byte
    private String username; // 아이디

    @Column(nullable = false, length = 100) // 123456 => Hash(비밀번호 암호화)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("'user'")
    private String role; // Enum을 쓰는게 좋다. // admin, user, manager // 도메인이 정해졌다 == 범위가 정해졌다

    @CreationTimestamp // 시간이 자동 입력
    private Timestamp createDate; // 날짜
}
