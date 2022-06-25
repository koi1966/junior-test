package com.example.juniortest.models.repo;

import com.example.juniortest.models.User;
import org.springframework.data.repository.CrudRepository;

public interface AddUser extends CrudRepository<User, Long> {


}
