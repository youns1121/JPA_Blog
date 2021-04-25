package com.ysmin.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/")
    public String index() {
        //WEB-INF/views/index2.jsp
        return "index2";
    }
}
