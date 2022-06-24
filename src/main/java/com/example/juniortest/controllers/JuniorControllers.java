package com.example.juniortest.controllers;

import com.example.juniortest.models.Users;
import com.example.juniortest.models.Voidd;
import com.example.juniortest.models.repo.VoiddRepository;
import com.example.juniortest.models.repo.AddUser;
import com.example.juniortest.models.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j   // Логер
@Controller
public class JuniorControllers {
private final AddUser addUser;
private final UserRepository userRepository;
private final VoiddRepository voiddRepository;

    public JuniorControllers(AddUser addUser, UserRepository userRepository, VoiddRepository voiddRepositoryRepository) {
        this.addUser = addUser;
        this.userRepository = userRepository;
        this.voiddRepository = voiddRepositoryRepository;
    }

    @GetMapping("/add")
    public String userAdd() {

        Users users = new Users();
        users.setName("rrffss");
        users.setAge(44);


        Voidd voidd = new Voidd();
        voidd.setName(" eee");
        voidd.setAge(33);
        voiddRepository.save(voidd);
        return " трям ";
    }
}
