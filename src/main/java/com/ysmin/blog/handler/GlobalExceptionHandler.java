package com.ysmin.blog.handler;


import com.ysmin.blog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler { // 오류가 난다면 이곳에서 리턴

    @ExceptionHandler(value = Exception.class) //잘못된 인자 전달 시 발생
    public ResponseDto<String> handleArgumentException(Exception e){
        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()); //500 error
    }
}
