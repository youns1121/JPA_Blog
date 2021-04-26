package com.ysmin.blog.repository;

import com.ysmin.blog.model.Board;
import com.ysmin.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
DAO
자동으로 bean등록이 됨
@Repository // 생략 가능
 */
public interface BoardRepository extends JpaRepository<Board, Integer> {


}
