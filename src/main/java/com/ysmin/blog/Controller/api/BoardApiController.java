package com.ysmin.blog.Controller.api;

import com.ysmin.blog.dto.ResponseDto;
import com.ysmin.blog.model.Board;
import com.ysmin.blog.model.RoleType;
import com.ysmin.blog.model.User;
import com.ysmin.blog.service.BoardService;
import com.ysmin.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, User user){
        boardService.글쓰기(board, user);

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);

    }
}
