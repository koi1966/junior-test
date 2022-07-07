package com.example.juniortest.models.repo;

import com.example.juniortest.models.UserJVT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJVTRepository extends JpaRepository<UserJVT, Long> {
    UserJVT findByUsername(String name);
}
