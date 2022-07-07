package com.example.juniortest.servise.impl;

import com.example.juniortest.models.Role;
import com.example.juniortest.models.Status;
import com.example.juniortest.models.UserJVT;
import com.example.juniortest.models.repo.RoleRepository;
import com.example.juniortest.models.repo.UserJVTRepository;
import com.example.juniortest.servise.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserJVTRepository userJVTRepository;
    private RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserJVTRepository userJVTRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userJVTRepository = userJVTRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserJVT register(UserJVT user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        users.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        userj registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<UserJVT> getAll() {
        return null;
    }

    @Override
    public UserJVT findByUsername(String username) {
        return null;
    }

    @Override
    public UserJVT findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
