package com.ysmin.blog.Controller;

<<<<<<< HEAD
import com.ysmin.blog.config.auth.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
=======
>>>>>>> 6a98001402c69fa11a917eead30b2635cf8cc5e2
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

<<<<<<< HEAD

    @GetMapping({"","/"})
    public String index(@AuthenticationPrincipal PrincipalDetail principal) { // 컨트롤러에서 세션을 어떻게 찾는지? : {"status":500,"data":null}
        //WEB-INF/views/index2.jsp
        System.out.println("로그인 사용자 아이디:"+principal.getUsername());

=======
    @GetMapping({"","/"})
    public String index() { // 컨트롤러에서 세션을 어떻게 찾는지?
        //WEB-INF/views/index2.jsp
>>>>>>> 6a98001402c69fa11a917eead30b2635cf8cc5e2
        return "index2";
    }


<<<<<<< HEAD
//    //USER 권한이 필요
//    @GetMapping("/board/saveForm")
//    public String saveForm() {
//        return "board/saveForm";
//    }
=======

    //USER 권한이 필요
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
>>>>>>> 6a98001402c69fa11a917eead30b2635cf8cc5e2
}
