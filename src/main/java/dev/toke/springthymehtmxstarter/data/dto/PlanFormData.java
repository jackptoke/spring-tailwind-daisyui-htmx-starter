package dev.toke.springthymehtmxstarter.data.dto;

import dev.toke.springthymehtmxstarter.data.model.*;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanFormData {
    private Long id;
    @NotBlank
    private String description;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDateTime runDate;
    private PlanPriority priority = PlanPriority.NORMAL;
    private ProductionStatus productionStatus;
    private TransferStatus transferStatus = TransferStatus.NEW;
    private Set<BatchOrder> workOrders = new HashSet<>();
    private Set<PlanMachine> selectedMachines = new HashSet<>();
}
