package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users_roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersRoles {
    @EmbeddedId
    private UserRoleId id = new UserRoleId();
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("roleId")
    private Role role;
}
