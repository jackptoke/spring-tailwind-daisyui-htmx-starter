package dev.toke.springthymehtmxstarter.service.impl;

import dev.toke.springthymehtmxstarter.data.model.UsersRoles;
import dev.toke.springthymehtmxstarter.repository.UsersRolesRepo;
import dev.toke.springthymehtmxstarter.service.RoleService;
import dev.toke.springthymehtmxstarter.service.UserService;
import dev.toke.springthymehtmxstarter.service.UsersRolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersRolesServiceImpl implements UsersRolesService {
    private final UsersRolesRepo usersRolesRepo;
    private final UserService userService;
    private final RoleService roleService;

    @Override
    public List<UsersRoles> getUsersRoles() {
        return usersRolesRepo.findAll();
    }

    @Override
    public List<UsersRoles> getUsersRolesByUserId(Long userId) {
        return usersRolesRepo.findByUsersId(userId);
    }

    @Override
    public UsersRoles getUsersRolesById(Long id) {
        return usersRolesRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public UsersRoles addUserRole(UsersRoles usersRoles) {
        var currentRoles = usersRolesRepo.findByUsersId(usersRoles.getUser().getId());
        if (!currentRoles.isEmpty()) {
            var result = currentRoles.stream().filter(r -> r.getRole().getId() == usersRoles.getRole().getId()).toList();
            if (!result.isEmpty()) {
                throw new RuntimeException("User already has this role");
            }
        }
        var user = userService.findById(usersRoles.getUser().getId());
        user.getRoles().add(usersRoles);

        var role = roleService.getUserRole(usersRoles.getRole().getId());
        usersRoles.setRole(role);
        usersRoles.setUser(user);
        user.getRoles().add(usersRoles);
        userService.save(user);
        return usersRoles;
    }

    @Override
    public void deleteUserRole(Long id) {

    }
}
