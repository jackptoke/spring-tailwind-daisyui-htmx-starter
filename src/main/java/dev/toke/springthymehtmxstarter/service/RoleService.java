package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getUserRoles();
    Role getUserRole(Long id);
    Role addRole(Role role);
    Role updateRole(Role role);
    void deleteRole(Long id);
}
