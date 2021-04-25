package com.ysmin.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  //View를 반환하기 위해 사용
public class UserController {

    @GetMapping("/user/joinForm")
    public String joinForm(){

        return "user/joinForm";

    }

    @GetMapping("/user/loginForm")
    public String loginForm(){

        return "user/loginForm";

    }
}
