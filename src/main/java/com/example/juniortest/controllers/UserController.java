package com.example.juniortest.controllers;

import com.example.juniortest.mapper.Mapper;
import com.example.juniortest.models.User;
import com.example.juniortest.models.dto.UserDTO;
import com.example.juniortest.repo.UserRepository;
import com.example.juniortest.servise.AddUser;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    private final AddUser addUser;
    private final Mapper mapper = Mappers.getMapper(Mapper.class);

    public UserController( AddUser addUser) {

        this.addUser = addUser;
    }

    @PostMapping(value = "/user")
    public UserDTO saveUser(@RequestBody UserDTO dto) {

        User user = mapper.userDtoToUser(dto);

        User saved = addUser.AddUsers(user);
        log.info("UserDto: {}, saved user: {}", dto, saved);

        return mapper.userToUserDto(saved);
    }

}
