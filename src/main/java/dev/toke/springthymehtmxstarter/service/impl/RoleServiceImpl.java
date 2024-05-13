package dev.toke.springthymehtmxstarter.service.impl;

import dev.toke.springthymehtmxstarter.data.model.Role;
import dev.toke.springthymehtmxstarter.repository.RoleRepo;
import dev.toke.springthymehtmxstarter.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    @Override
    public List<Role> getUserRoles() {
        return roleRepo.findAll();
    }

    @Override
    public Role getUserRole(Long id) {
        return roleRepo.findById(id).orElse(null);
    }

    @Override
    public Role addRole(Role role) {
        var existingRole = roleRepo.findByName(role.getName());
        if(existingRole != null) {
            throw new RuntimeException("Role already exists");
        }
        return roleRepo.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        var existingRole = roleRepo.findById(role.getId()).orElse(null);
        if(existingRole == null) {
            throw new RuntimeException("Role not found");
        }
        existingRole.setName(role.getName());
        existingRole.setDescription(role.getDescription());

        return roleRepo.save(existingRole);
    }

    @Override
    public void deleteRole(Long id) {
        var existingRole = roleRepo.findById(id).orElse(null);
        if(existingRole == null) {
            throw new RuntimeException("Role not found");
        }
        roleRepo.deleteById(id);
    }
}
