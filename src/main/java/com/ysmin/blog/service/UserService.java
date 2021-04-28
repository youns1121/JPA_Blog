package com.ysmin.blog.service;

<<<<<<< HEAD
import com.ysmin.blog.model.RoleType;
import com.ysmin.blog.model.User;
import com.ysmin.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



    //스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해줌
    @Service
    public class UserService {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private BCryptPasswordEncoder encoder;

        @Transactional
        public void 회원가입(User user){
            String rawPassword = user.getPassword(); // 1234 원문
            String encPassword = encoder.encode(rawPassword); // 해쉬
            user.setPassword(encPassword);
            user.setRole(RoleType.USER);
            userRepository.save(user); // 오류가 난다면
        }

    
=======
import com.ysmin.blog.model.User;
import com.ysmin.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해줌
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void 회원가입(User user){
            userRepository.save(user); // 오류가 난다면
    }

>>>>>>> 6a98001402c69fa11a917eead30b2635cf8cc5e2
}
