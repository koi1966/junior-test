package com.example.juniortest.rest;

import com.example.juniortest.dto.UserDtoJ;
import com.example.juniortest.models.UserJVT;
import com.example.juniortest.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users/")
public class UserRestControllerV1 {
    private final UserService userService;

    @Autowired
    public UserRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDtoJ> getUserById(@PathVariable(name = "id") Long id){
        UserJVT user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDtoJ result = UserDtoJ.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}