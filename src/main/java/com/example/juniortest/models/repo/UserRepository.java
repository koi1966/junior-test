package com.example.juniortest.models.repo;

import com.example.juniortest.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}