package com.example.juniortest.mapper;

import com.example.juniortest.models.Status;
import com.example.juniortest.models.User;
import com.example.juniortest.models.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapperImplTest {

    private final Mapper mapper = Mappers.getMapper(Mapper.class);

    @Test
    void userToUserDtoTest() {
//given
        User user = new User();
//        user.setId(1L);
        user.setName("oleg");
        user.setAge(18);
        user.setEmail("dedd@ddd.com");
        user.setStatus(Status.ACTIVE);

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