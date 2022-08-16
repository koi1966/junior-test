package com.example.juniortest.models.repo;

import com.example.juniortest.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserRepositoryTest {

    private static final long ID = 1L;

    @Autowired
    private UserRepository repository;

    @Test
    void findByEmail() {
        Optional<User> user = repository.findByEmail("admin@ukr.net");

        assertTrue(user.isPresent());
        assertEquals(true, user.isPresent());
        assertEquals("ADMIN", user.get().getRole().toString());

    }


    @Test
    void addUser() {


    }


}