package com.example.juniortest.servise.impl;

import com.example.juniortest.models.Role;
import com.example.juniortest.models.Status;
import com.example.juniortest.models.UserJVT;
import com.example.juniortest.models.repo.RoleRepository;
import com.example.juniortest.models.repo.UserJVTRepository;
import com.example.juniortest.servise.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    private final UserJVTRepository userJVTRepository;
    private final RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserJVTRepository userJVTRepository, RoleRepository roleRepository) {
        this.userJVTRepository = userJVTRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserJVT register(UserJVT userJVT) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        userJVT.setPassword(passwordEncoder.encode(userJVT.getPassword()));
        userJVT.setRoles(userRoles);
        userJVT.setStatus(Status.ACTIVE);
        UserJVT registeredUser = userJVTRepository.save(userJVT);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<UserJVT> getAll() {
        List<UserJVT> result = userJVTRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public UserJVT findByUsername(String username) {
        UserJVT result = userJVTRepository.findByUsername(username);
        log.info("IN findBy Name - user: {} found by username: {}", result,username);
        return result;
    }

    @Override
    public UserJVT findById(Long id) {
        UserJVT result = userJVTRepository.findById(id).orElse(null);
        if (result == null){
            log.warn("IN findById - no user found by id: {}",id);
            return null;
        }
        log.info("IN findBy Name - user: {} found by username: {}", result);
        return null;
    }

    @Override
    public void delete(Long id) {
        userJVTRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfulluty deleted");
    }
}
