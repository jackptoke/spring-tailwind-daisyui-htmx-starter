package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AmeUser")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    @NotBlank
    private String username;
    @Column(unique = true, nullable = false)
    @NotBlank
    private String email;
    @Column(nullable = false)
    @NotBlank
    private String password;
    private Boolean isActive;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UsersRoles> roles = new HashSet<>();
}
