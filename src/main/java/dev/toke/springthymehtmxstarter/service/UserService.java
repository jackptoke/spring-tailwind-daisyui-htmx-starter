package dev.toke.springthymehtmxstarter.service;


import dev.toke.springthymehtmxstarter.data.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findUsersByIsActiveStatus(Boolean isActive);
    User findById(Long id);
    User findByUsername(String username);
    User findByEmail(String email);
    User save(User user);
    void delete(Long id);
    void deleteAll();
}
