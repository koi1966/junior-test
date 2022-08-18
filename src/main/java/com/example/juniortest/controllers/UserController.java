package com.example.juniortest.controllers;

import com.example.juniortest.mapper.Mapper;
import com.example.juniortest.models.User;
import com.example.juniortest.models.dto.UserDTO;
import com.example.juniortest.servise.ServiceUser;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {

    private final ServiceUser serviceUser;
    private final Mapper mapper = Mappers.getMapper(Mapper.class);

    public UserController(ServiceUser addUser) {

        this.serviceUser = addUser;
    }

//    @GetMapping
//    public List<User> getAll() {
//        return DEVELOPERS;
//    }

    @PostMapping(value = "/add")
    @PreAuthorize("hasAuthority('developers:write')")
    public UserDTO saveUser(@RequestBody UserDTO dto) {

        User user = mapper.userDtoToUser(dto);

        User saved = serviceUser.AddUsers(user);
        log.info("UserDto: {}, saved user: {}", dto, saved);

        return mapper.userToUserDto(saved);
    }

    @GetMapping("/age")
    @PreAuthorize("hasAuthority('developers:read')")
    public List<UserDTO> searchUser(@RequestParam int age) {
        log.info("All users age > {}", age);
        List<User> user = serviceUser.userList(age);
        return mapper.map(user);
    }

    @GetMapping("/countartic")
    @PreAuthorize("hasAuthority('developers:read')")
    public List<UserDTO> searchCountUserInArticle(@RequestParam int count) {
        log.info("All users in article > {}", count);
        List<User> user = serviceUser.searchUserCountArticle(count);
        return mapper.map(user);
    }

    @GetMapping("/userall")
    @PreAuthorize("hasAuthority('developers:read')")
    public List<UserDTO> searchCountUserInArticle() {
        log.info("All users in article >");
        List<User> user = serviceUser.searchAllUser();
        return mapper.map(user);
    }
}
