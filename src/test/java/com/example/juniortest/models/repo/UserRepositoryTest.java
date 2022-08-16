package com.example.juniortest.models.repo;

import com.example.juniortest.models.User;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class UserRepositoryTest {

    private UserRepository userRepository;

    @Test
    void findByEmail() {
       Optional<User> user = userRepository.findByEmail("admin@ukr.net");
        assertNull(user);
    //        Assertions.assertEquals("серпень", nameMonth);
        }

    @Test
    void addUser() {
       User user = new User("admin", "Klymchyk", 25,"admin@ukr.net","0","0","0","0","0");

       userRepository.save(user);

//        Student student = new Student(1, "john");
//        studentRepository.save(student);
//
//        Student student2 = studentRepository.findOne(1);
//        assertEquals("john", student2.getName());
    }


}