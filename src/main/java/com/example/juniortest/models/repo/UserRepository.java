package com.example.juniortest.models.repo;

import com.example.juniortest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM users WHERE age > :age")
    List<User> findByUserAge(@Param("age") long age);


    @Query(nativeQuery = true,
            value = "select * from users where id in  (select user_id from article group by  user_id having count(*) >:cou)")
    List<User> findByUserInArticleCount(@Param("cou") int cou);

    @Query(nativeQuery = true,
            value = "select * from users age > cou")
    List<User> allsUser(@Param("cou") int cou);

}