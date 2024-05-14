package dev.toke.springthymehtmxstarter.repository;

import dev.toke.springthymehtmxstarter.data.model.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRolesRepo extends JpaRepository<UsersRoles, Long> {
    @Query(value = "SELECT * FROM UsersRoles WHERE user_id = :userId", nativeQuery = true)
    List<UsersRoles> findByUsersId(Long userId);
}
