package com.shelter.coursework.repository;

import com.shelter.coursework.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    public User findByLogin(String login);
}
