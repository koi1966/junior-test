package com.example.juniortest.controllers;

import com.example.juniortest.mapper.Mapper;
import com.example.juniortest.models.User;
import com.example.juniortest.models.dto.UserDTO;
import com.example.juniortest.servise.ServisesUser;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

    private final ServisesUser servisesUser;
    private final Mapper mapper = Mappers.getMapper(Mapper.class);

    public UserController(ServisesUser addUser) {

        this.servisesUser = addUser;
    }

    @PostMapping(value = "/add")
    public UserDTO saveUser(@RequestBody UserDTO dto) {

        User user = mapper.userDtoToUser(dto);

        User saved = servisesUser.AddUsers(user);
        log.info("UserDto: {}, saved user: {}", dto, saved);

        return mapper.userToUserDto(saved);
    }

    @GetMapping("/userage")
    public List<UserDTO> searchUser(@RequestParam int age) {
        log.info("All users age > {}", age);
        List<User> user = servisesUser.userList(age);
        return mapper.map(user);
    }


    @GetMapping("/userartic")
    public List<UserDTO> searchCountUserInArticle(@RequestParam int count) {
        log.info("All users in article > {}", count);
        List<User> user = servisesUser.searchUserCountArticle(count);
        return mapper.map(user);
    }
}
