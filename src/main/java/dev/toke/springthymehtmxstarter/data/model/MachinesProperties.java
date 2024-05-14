package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "MACHINES_PROPERTIES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MachinesProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    private Machine machine;

    @ManyToOne
    @JoinColumn(name = "machineProperty_id", referencedColumnName = "id")
    private MachineProperty machineProperty;
}
