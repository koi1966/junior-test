package com.example.juniortest.models.repo;

import com.example.juniortest.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserRepositoryTest {

    private static final long ID = 1L;

    @Autowired
    private UserRepository repository;

    @Test
    void findByEmail() {
       Optional<User> user = repository.findByEmail("admin@ukr.net");
        assertNotNull(user.);
    //        Assertions.assertEquals("серпень", nameMonth);
        }

    @Test
    void addUser() {
        User mock = org.mockito.Mockito.mock(User.class);
        when(mock.getId()).thenReturn(ID);

        //        this.repository.findById(ID);
        repository.save(mock);
        List<User> actual = repository.findById(ID);

        assertNotNull(actual);
        assertEquals(mock, actual);

    }


}