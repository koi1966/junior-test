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
}