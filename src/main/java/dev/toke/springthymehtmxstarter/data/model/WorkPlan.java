package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "WorkPlan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkPlan {
    @Id
    private Long id;
    private String description;
    private LocalDate startDate;
    private LocalDateTime runDate;
    private PlanPriority priority = PlanPriority.NORMAL;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workplanstatus_id")
    private ProductionStatus productionStatus;
    private TransferStatus transferStatus;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workPlan")
    private Set<BatchOrder> workOrders = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY)
    private Set<PlanMachine> selectedMachines = new HashSet<>();
}
