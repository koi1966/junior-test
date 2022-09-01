package com.example.juniortest.controllers;

import com.example.juniortest.models.Role;
import com.example.juniortest.models.Status;
import com.example.juniortest.models.User;
import com.example.juniortest.security.JwtTokenProvider;
import com.example.juniortest.servise.ServiceUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private ServiceUser serviceUser;

    public static class TestUtil {

        public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
                MediaType.APPLICATION_JSON.getSubtype(),
                StandardCharsets.UTF_8
        );
    }

    @Test
    void searchUser() throws Exception {

        User user = new User();
        user.setName("oleg");
        user.setAge(18);
        user.setStatus(Status.valueOf("ACTIVE"));
        user.setFirstName("User_1897");
        user.setPassword("123456");
        user.setEmail("uuaa@meta.ua");
        user.setRole(Role.USER);

       User userSave = serviceUser.AddUsers(user);

        mockMvc.perform(get("/user/userall")
                        .header("Authorization",
                                jwtTokenProvider.createToken(userSave.getEmail(),
                                String.valueOf(userSave.getRole()))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.[0].name").value("admin"))
                .andExpect(jsonPath("$.[1].name").value("user"));
    }
}