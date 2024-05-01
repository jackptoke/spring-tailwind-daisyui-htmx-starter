package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MachinesProperties {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    private Machine machine;

    @ManyToOne
    @JoinColumn(name = "machineProperty_id", referencedColumnName = "id")
    private MachineProperty machineProperty;
}
