package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Machines")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    private String dataPath;  // WPCS data path
    private String feedbackPath; // WPCS feedback path
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String updatedBy;
    @OneToMany(mappedBy = "machine")
    private Set<MachinesProperties> properties = new HashSet<>();

    public Set<MachinesProperties> getProperties() {
        if(Objects.isNull(properties)) return Collections.emptySet();
        return properties;
    }

    void update(Machine machine) {
        this.name = machine.getName();
        this.description = machine.getDescription();
        this.brand = machine.getBrand();
        this.model = machine.getModel();
        this.dataPath = machine.getDataPath();
        this.feedbackPath = machine.getFeedbackPath();
        this.isActive = machine.getIsActive();
        this.user = machine.getUser();
        this.updatedAt = machine.getUpdatedAt();
        this.updatedBy = machine.getUpdatedBy();
        this.properties.clear();
        this.properties.addAll(machine.getProperties());
    }
}

