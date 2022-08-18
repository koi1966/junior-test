package com.example.juniortest.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RunWith(SpringJUnit4ClassRunner.class)
@RestController
@RequestMapping("/user")
@EnableGlobalMethodSecurity(prePostEnabled = true)
class UserControllerTest {

    private MockMvc mockMvc;


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