package com.ysmin.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터
    private String content; // 섬머노트 라이브러리리 <html>태그가 섞여서 디자인이 됨.

    @ColumnDefault("0") //DB의 넘버값
    private int count; // 조회수

    @ManyToOne // Many = Board, User = One : 한명의 유저는 여러 게시글을 사용할 수 있다
    @JoinColumn(name="userId") // 필드값은 'userId'
    private User user; // DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트 저장할 수 있다.

    @OneToMany(mappedBy = "board") // mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 컬럼을 만들지 마세요
    private List<Reply> reply;

    @CreationTimestamp // 시간이 자동 입력
    private Timestamp createDate; // 날짜
}
