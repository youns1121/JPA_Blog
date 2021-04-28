package com.ysmin.blog.repository;

import com.ysmin.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/*
DAO
자동으로 bean등록이 됨
@Repository // 생략 가능
 */
public interface UserRepository extends JpaRepository<User, Integer> {

<<<<<<< HEAD
    Optional<User> findByUsername(String username);
=======
>>>>>>> 6a98001402c69fa11a917eead30b2635cf8cc5e2

}



//JPA Naming 전략
// Select * from user where usernam= ? AND password =?;
//    User findUsernameAndPassword(String username, String password);

//    @Query(value = "SELECT * FROM user WHERE username = ?1 AND password =?2", nativeQuery = true)
//    User login(String username, String password);
//    Optional<User> findByUsername(String username);