package com.example.juniortest.models.repo;

import com.example.juniortest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}