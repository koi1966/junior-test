package com.example.juniortest.models.repo;

import com.example.juniortest.models.Status;
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
        assertEquals("ADMIN", user.get().getRole().toString());

    }

    @Test
    void addUser() {

        User user = new User();
        user.setName("oleg");
        user.setAge(18);
        user.setStatus(Status.valueOf("ACTIVE"));
        user.setFirstName("User_1897");
        user.setPassword("123456");
        user.setEmail("uuaa@meta.ua");
        repository.save(user);

        User userTest = repository.findByEmail("uuaa@meta.ua").orElseGet(User::new);

        assertEquals(user.getPassword(), userTest.getPassword());
        assertEquals( user.getEmail(), userTest.getEmail());

    }

}