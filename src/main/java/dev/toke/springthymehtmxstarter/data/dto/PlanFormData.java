package dev.toke.springthymehtmxstarter.data.dto;

import dev.toke.springthymehtmxstarter.data.model.*;
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
    private String harness;
    private String revision;
    private Integer quantity;
    @NotBlank
    private String description;
    @NotNull
    private LocalDateTime runDate;
    private LocalDate releaseByDate;
    private LocalDate dueInStoreDate;
    private PlanPriority priority = PlanPriority.NORMAL;
    private ProductionStatusDto productionStatusDto;
    private TransferStatus transferStatus = TransferStatus.NEW;
    private Set<BatchOrder> workOrders = new HashSet<>();
    private Set<PlanMachine> selectedMachines = new HashSet<>();
    private String startSite = "";
    private String startLocation = "";
    private String deliverySite = "";
    private String deliveryLocation = "";
    private String specialCode;
}
