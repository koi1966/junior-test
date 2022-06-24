package com.example.juniortest.models.repo;

import com.example.juniortest.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface AddUser extends CrudRepository<Users, Long> {


}
