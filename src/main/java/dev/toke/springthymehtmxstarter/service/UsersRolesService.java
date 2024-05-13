package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.model.UsersRoles;

import java.util.List;

public interface UsersRolesService {
    List<UsersRoles> getUsersRoles();
    List<UsersRoles> getUsersRolesByUserId(Long userId);
    UsersRoles getUsersRolesById(Long id);
    UsersRoles addUserRole(UsersRoles usersRoles);
    void deleteUserRole(Long id);

}
