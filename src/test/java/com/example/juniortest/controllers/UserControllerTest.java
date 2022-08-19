package com.example.juniortest.controllers;

import com.example.juniortest.models.Status;
import com.example.juniortest.models.User;
import com.example.juniortest.servise.ServiceUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RestController
@RequestMapping("/user")
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@WebAppConfiguration
class UserControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private ServiceUser serviceUserMock;

    public static class TestUtil {

        public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
                MediaType.APPLICATION_JSON.getSubtype(),
                StandardCharsets.UTF_8
        );
    }

    @Test
    void saveUser() throws Exception{

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

        when(serviceUserMock.findAllUser()).thenReturn(List.of(user));

        mockMvc.perform(get("/userall"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect((ResultMatcher) jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].id", is(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].description", is("Lorem ipsum")))
                .andExpect((ResultMatcher) jsonPath("$[0].title", is("Foo")));

        verify(serviceUserMock, times(1)).findAllUser();
        verifyNoMoreInteractions(serviceUserMock);
    }


    @Test
    void searchCountUserInArticle() {
    }

    @Test
    void testSearchCountUserInArticle() {
    }
}