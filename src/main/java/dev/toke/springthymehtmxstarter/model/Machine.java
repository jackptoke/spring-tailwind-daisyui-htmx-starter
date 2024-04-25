package dev.toke.springthymehtmxstarter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Machine")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String ipAddress;
}
