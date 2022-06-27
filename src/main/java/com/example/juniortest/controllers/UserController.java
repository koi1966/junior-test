package com.example.juniortest.controllers;

import com.example.juniortest.mapper.Mapper;
import com.example.juniortest.models.User;
import com.example.juniortest.models.dto.UserDTO;
import com.example.juniortest.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {
    private final UserRepository userRepository;
    private final Mapper mapper = Mappers.getMapper(Mapper.class);

    public UserController(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @PostMapping(value = "/user")
    public UserDTO saveUser(@RequestBody UserDTO dto) {

        User user = mapper.userDtoToUser(dto);

        User saved = userRepository.save(user);
        log.info("UserDto: {}, saved user: {}", dto, saved);

//        List<User> usr = userRepository.findAll();

        return mapper.userToUserDto(saved);
    }

}
