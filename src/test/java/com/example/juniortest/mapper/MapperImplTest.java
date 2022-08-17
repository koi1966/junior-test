package com.example.juniortest.mapper;

import com.example.juniortest.models.Status;
import com.example.juniortest.models.User;
import com.example.juniortest.models.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapperImplTest {

     private final Mapper mapper;

    MapperImplTest(MapperImpl mapperUnderTest) {
        this.mapper = mapperUnderTest;
    }


    @Test
    void userToUserDtoTest() {
//given
        User user = new User();
//        user.setId(1L);
        user.setName("oleg");
        user.setAge(18);
        user.setEmail("dedd@ddd.com");
        user.setStatus(Status.valueOf("ACTIVE"));
        user.setStatus(Status.valueOf("ACTIVE"));

        //when
        UserDTO Urdto = mapper.userToUserDto(user);

        //then
        Assertions.assertNotNull(Urdto);
        Assertions.assertEquals(user.getAge(), Urdto.getAge());
        Assertions.assertEquals(user.getName(), Urdto.getName());
    }

    @Test
    void userDtoToUser() {
    }

    @Test
    void articleToArticleDTO() {
    }

    @Test
    void articleDtoToArticle() {
    }

    public Mapper getMapper() {
        return mapper;
    }
}