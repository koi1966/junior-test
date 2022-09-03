package com.example.juniortest.models.repo;

import com.example.juniortest.models.Status;
import com.example.juniortest.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class UserRepositoryTest {

    private static final long ID = 1L;

    @Autowired
    private UserRepository repository;

    @Test
    void findByEmail() {
        Optional<User> user = repository.findByEmail("admin@ukr.net");

        assertTrue(user.isPresent());
        assertEquals("ADMIN", user.get().getRole().toString());

        List<User> users = this.repository.findAll();
        // Assert
        assertThat(users).isNotNull();
        assertThat(users).hasSize(20);

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