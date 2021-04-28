package com.ysmin.blog.Controller.api;

import com.ysmin.blog.config.auth.PrincipalDetail;
import com.ysmin.blog.dto.ResponseDto;
import com.ysmin.blog.model.Board;
import com.ysmin.blog.model.RoleType;
import com.ysmin.blog.model.User;
import com.ysmin.blog.service.BoardService;
import com.ysmin.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {

        boardService.글쓰기(board, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id) {
        boardService.글삭제하기(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }


    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
        System.out.println("BoardApiController : update : id= " + id);
        System.out.println("BoardApiController : update : board = "+ board.getTitle());
        System.out.println("BoardApiController : update : board = " + board.getContent());

        boardService.글수정하기(id, board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
