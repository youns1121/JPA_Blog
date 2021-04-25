package com.ysmin.blog.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class) //잘못된 인자 전달 시 발생
    public String handleArgumentException(IllegalArgumentException e){
        return "<h1>" + e.getMessage()+ "</h1>";
    }
}
