package com.ysmin.blog.service;

import com.ysmin.blog.model.Board;
import com.ysmin.blog.model.User;
import com.ysmin.blog.repository.BoardRepository;
import com.ysmin.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해줌
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void 글쓰기(Board board, User user){ // title, content

            board.setCount(0);
            board.setUser(user);
            boardRepository.save(board);

    }

    public Page<Board> 글목록(Pageable pageable){
        return boardRepository.findAll(pageable);
    }
}
