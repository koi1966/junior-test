package com.example.juniortest.servise;

import com.example.juniortest.models.UserJVT;

import java.util.List;

public interface UserService {
    UserJVT register(UserJVT user);

    List<UserJVT> getAll();

    UserJVT findByUsername(String username);

    UserJVT findById(Long id);

    void delete(Long id);
}
