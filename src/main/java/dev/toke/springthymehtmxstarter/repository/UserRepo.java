package dev.toke.springthymehtmxstarter.repository;

import dev.toke.springthymehtmxstarter.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM AmeUsers WHERE username = :username", nativeQuery = true)
    User findByUsername(String username);
    @Query(value = "SELECT * FROM AmeUsers WHERE email = :email", nativeQuery = true)
    User findByEmail(String email);
    @Query(value = "SELECT * FROM AmeUsers WHERE isActive = :isActive", nativeQuery = true)
    List<User> findUsersByIsActive(boolean isActive);
}
