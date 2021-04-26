package com.ysmin.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping({"","/"})
    public String index() { // 컨트롤러에서 세션을 어떻게 찾는지?
        //WEB-INF/views/index2.jsp
        return "index2";
    }



    //USER 권한이 필요
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
}
