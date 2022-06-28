package com.example.juniortest.servise;

import com.example.juniortest.models.User;
import com.example.juniortest.models.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ServisesUser {
    private final UserRepository userRepository;

    public ServisesUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User AddUsers(User user) {
        log.info("User add: {} ", user);
        return userRepository.save(user);
    }

    public List<User> userList(int age) {
     return userRepository.findByUserAge(age);
    }
}
