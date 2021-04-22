package com.ysmin.blog;


import com.ysmin.blog.model.RoleType;
import com.ysmin.blog.model.User;
import com.ysmin.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

//html파일이 아니라 data를 리턴해주는 controller = RestController
@RestController
public class DummyControllerTest {

    @Autowired //의존성 주입(DI)
    private UserRepository userRepository;

    // {id} 주소로 파라미털르 전달 받을 수 있음
    // http://localhost:8080/blog/dummy/user/5
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){
        /*
        user /4을 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null이 될 것 아냐?
        그럼 return null 이 리턴이 되자나.. 그럼 프로그램에 문제가 있지 않겠니?
        Optional로 너의 User 객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return해!!
         */

        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id: " + id);
            }
        });
        /*
        요청 : 웹브라우저
        user 객체 = 자바 오브젝트
        변환 (웹브라우저가 이해할 수 있는 데이터) -> json (Gson 라이브러리)
        스프링부트 = MessageConverter가 응답시에 자동 작동
        만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jakcon 라이브러리를 호출해서
        user 오브젝트를 json으로 변환해서 브라우저에게 던져줌
         */

        return user;
    }

     /*
     http://localhost:8080/blog/dummy/join => 요청
     http의 body에 username, password, email 데이터를 가지고 => 요청
      */
    @PostMapping("/dummy/join")
    public String join(User user) {//회원가입, insert, key : value (약속된 규칙)
        System.out.println("username = " + user.getUsername());
        System.out.println("password = " + user.getPassword());
        System.out.println("email = " + user.getEmail());
        System.out.println("user.getRole() = " + user.getRole());
        System.out.println("user.getCreateDate() = " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";

    }
}
