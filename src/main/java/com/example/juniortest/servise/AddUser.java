package com.example.juniortest.servise;
import com.example.juniortest.models.User;
import com.example.juniortest.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AddUser {
    private final UserRepository userRepository;

    public AddUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User AddUsers(User user){
        log.info("User add: {} ", user);
        return userRepository.save(user);
    }
}
