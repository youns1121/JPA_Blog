package com.ysmin.blog.Controller;

import com.ysmin.blog.config.auth.PrincipalDetail;
import com.ysmin.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 컨트롤러에서 세션을 어떻게 찾는지? : {"status":500,"data":null}
    //WEB-INF/views/index2.jsp
    //@AuthenticationPrincipal PrincipalDetail principal
    @GetMapping({"","/"})
    public String index(Model model) {

        model.addAttribute("boards", boardService.글목록()); // model은 jsp에서 request 정보
        return "index2"; //viewResolver 작동!!
    }

    //USER 권한이 필요
    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }
}
