package com.example.juniortest.controllers;

import com.example.juniortest.models.User;
import com.example.juniortest.models.repo.AddUser;
import com.example.juniortest.models.repo.UserRepository;
import com.example.juniortest.models.repo.VoiddRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j   // Логер
@RestController
public class JuniorControllers {
    private final AddUser addUser;
    private final UserRepository userRepository;
    private final VoiddRepository voiddRepository;


    public JuniorControllers(AddUser addUser, UserRepository userRepository, VoiddRepository voiddRepositoryRepository) {
        this.addUser = addUser;
        this.userRepository = userRepository;
        this.voiddRepository = voiddRepositoryRepository;
    }

    @PostMapping("/add")
    public List<User> userAdd(@RequestParam String s) {
//    public List<User> userAdd() {


        List<User> usr = userRepository.findAll();
//        Color color = Color.getRandomColor();
//        Color[] colors = Color.values()userRepository = {$Proxy104@10012} "org.springframework.data.jpa.repository.support.SimpleJpaRepository@1beb1c59";
//        colors.length;

//        color.getDeclaringClass();
        return usr;
    }
}
