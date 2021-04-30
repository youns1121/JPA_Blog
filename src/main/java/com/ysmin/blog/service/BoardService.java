package com.ysmin.blog.service;

import com.ysmin.blog.Controller.ReplySaveRequestDto;
import com.ysmin.blog.model.Board;
import com.ysmin.blog.model.Reply;
import com.ysmin.blog.model.User;
import com.ysmin.blog.repository.BoardRepository;

import com.ysmin.blog.repository.ReplyRepository;
import com.ysmin.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해줌
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private UserRepository userRepository;

//     @Autowired
//     private UserRepository userRepository;
//              위아래 같은 결과
///    public BoardService(BoardRepository bRepo, ReplyRepository rRepo){
//        this.boardRepository = bRepo;
//        this.replyRepository = rRepo;
//    }

    @Transactional
    public void 글쓰기(Board board, User user){ // title, content

            board.setCount(0);
            board.setUser(user);
            boardRepository.save(board);

    }

    @Transactional(readOnly = true)
    public Page<Board> 글목록(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board 글상세보기(int id){
        return boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
                });
    }

    @Transactional
    public void 글삭제하기(int id){

        System.out.println("글 삭제하기: " + id);
        boardRepository.deleteById(id);
    }

    @Transactional
    public void 글수정하기(int id, Board requestBoard){
        Board board = boardRepository.findById(id)  // 영속성 컨텍스트에 board가 들어감
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 찾기 실패: 아이디를 찾을 수 없습니다.");
                }); // 영속화 완료

        board.setTitle((requestBoard.getTitle()));
        board.setContent(requestBoard.getContent());
        //해당 함수로 종료시(Service가 종료될 때) 트랜잭션이 종료됩니다. 이때 더티체킹 - 자동 업데이트가 됨. db flush

    }

    @Transactional
    public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {

        User user = userRepository.findById(replySaveRequestDto.getUserId())
                .orElseThrow(()->{
                    return new IllegalArgumentException("댓글 쓰기 실패: 유저 id를 찾을 수 없습니다.");
                }); // 영속화 완료

        Board board = boardRepository.findById(replySaveRequestDto.getBoardId())
                .orElseThrow(()->{
                    return new IllegalArgumentException("댓글 쓰기 실패: 게시글 id를 찾을 수 없습니다.");
                }); // 영속화 완료

        Reply reply = Reply.builder()
                .user(user)
                .board(board)
                .content(replySaveRequestDto.getContent())
                .build();


//        requestReply.setUser(user);
//        requestReply.setBoard(board);

        replyRepository.save(reply);
    }

    @Transactional
    public void 댓글삭제(int replyId) {
        replyRepository.deleteById(replyId);
    }
}
