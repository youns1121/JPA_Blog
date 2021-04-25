package com.ysmin.blog;

import org.springframework.web.bind.annotation.*;


/**
 * 사용자가 요청 -> 응답(HTML 파일)
 * @Controller
 */

@RestController // 사용자가 요청 -> 응답(Data)
public class HttpControllerTest {

    private static final String TAG="HttpControllerTest : ";

    @GetMapping("/http/lombok")
    public String lombokTest(){
//        Member m = new Member(1, "ssar", "1234","minys94@daum.net");
        Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build(); // 빌드패턴
        System.out.println(TAG+"getter: "+m.getId());
        m.setId(5000);
        System.out.println(TAG+"setter: "+m.getId());

        return "lombok test 완료";

    }


    //인터넷 브라우저 요청은 무조건 get요청밖에 할 수 없다. , 쿼리스트링 밖에 없음
    //http://localhost:8080/http/get  (selete)
    @GetMapping("/http/get")
    public String getTest(Member m){//id=1&username=ssar&password=1234&email=ssar@nate.com


        return "get 요청: "+m.getId()+","+m.getUsername()+", "+m.getPassword()+","+m.getEmail();
    }

    //http://localhost:8080/http/post (insert)
    @PostMapping("/http/post") //text/plain, application/json
    public String postTest(@RequestBody Member m){ // MessageConverter(스프링 부트)
        return "post 요청: "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
    }

    //http://localhost:8080/http/put (update)
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m){
        return "put 요청"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
    }

    //http://localhost:8080/http/delete (delete)
    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }

}
