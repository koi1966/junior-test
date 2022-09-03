package com.example.juniortest.servise;

import com.example.juniortest.models.Status;
import com.example.juniortest.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ServiceUserTest {

    @Autowired
    private ServiceUser serviceUserTest;

    @Test
    void addUsers() {
        List<User> users = serviceUserTest.findAllUser();

        // Assert
        assertThat(users).isNotNull();
        assertThat(users).hasSize(20);

        User user = new User();
        user.setName("oleg");
        user.setAge(18);
        user.setStatus(Status.valueOf("ACTIVE"));
        user.setFirstName("User_1897");
        user.setPassword("123456");
        user.setEmail("uuaa@meta.ua");
        // Act
        serviceUserTest.AddUsers(user);
        // Assert
        List<User> usersAfterMutations = serviceUserTest.findAllUser();
        assertThat(usersAfterMutations).isNotNull();
        assertThat(usersAfterMutations).hasSize(21);
    }

    @Test
    void userList() {

        List<User> users = serviceUserTest.findAllUser();
        // Assert
        assertThat(users).isNotNull();
        assertThat(users).hasSize(20);
    }

    @Test
    void searchUserCountArticle() {
        List<User> users = serviceUserTest.searchUserCountArticle(3);
        assertThat(users).isNotNull();
//        assertThat(users).isExactlyInstanceOf().toString();
        assertThat(users).hasSize(5);
    }
}