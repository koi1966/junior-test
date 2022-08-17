package com.example.juniortest.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;

@RestController
@RequestMapping("/user")
@EnableGlobalMethodSecurity(prePostEnabled = true)
class UserControllerTest {

    @Test
    void saveUser() {

    }

    @Test
    void searchUser() {
    }

    @Test
    void searchCountUserInArticle() {
    }

    @Test
    void testSearchCountUserInArticle() {
    }
}