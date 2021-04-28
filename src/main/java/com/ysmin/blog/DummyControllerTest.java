package com.ysmin.blog;


import com.ysmin.blog.model.RoleType;
import com.ysmin.blog.model.User;
import com.ysmin.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Supplier;

//html파일이 아니라 data를 리턴해주는 controller = RestController
@RestController
public class DummyControllerTest {

    @Autowired //의존성 주입(DI)
    private UserRepository userRepository;

    //http://localhost:8080/blog/dummy/user
    @GetMapping("/dummy/users")
    public List<User> list(){
        return userRepository.findAll();
    }

    //save함수는 id를 전달하지 않으면 insert를 해주고
    //save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
    //save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 합니다
    //email, password

    @DeleteMapping("dummy/user/{id}")
    public String delete(@PathVariable int id){
        try{
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
        }

        return "삭제되었습니다. id: "+id;
    }

    @Transactional // 함수 종료시에 자동 commit 이 됨.
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){ // json 데이터를 요청 => Java Object(MessageConverter의 Jackson라이브러리가 변환해서 받아줌)
        System.out.println("id "+id);
        System.out.println("Password: = " + requestUser.getPassword());
        System.out.println("Email:  " + requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(()->{//실제 데이터를 담고 ,자바는 파라미터에 함수를 집어 넣을 수 없음, 영속화가 됨
            return new IllegalArgumentException("수정에 실패하였습니다");
        });

        //데이터 업데이트 과정
        user.setPassword(requestUser.getPassword()); // 데이터를 변경함
        user.setEmail(requestUser.getEmail());

//        requestUser.setId(id);
//        requestUser.setUsername("ssar");
//        userRepository.save(user); //save는 Insert 할때 사용

        // @Transactional를 사용하여 더티 체킹 = > 1차 캐시에 변경 감지가 되면 DB에 수정을 날림
       return null;

    }

    //한페이지당 2건에 데이터를 리턴 받아 볼 예정
    @GetMapping("/dummy/user") //페이징 하기
    public Page<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<User> pagingUser = userRepository.findAll(pageable);

        List<User> users = pagingUser.getContent();
        return pagingUser;
    }

    // {id} 주소로 파라미터터르 전달 받을수 있음
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
