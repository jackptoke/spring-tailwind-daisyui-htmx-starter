package dev.toke.springthymehtmxstarter.data.dto;

import dev.toke.springthymehtmxstarter.data.model.ProductionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkPlanDto {
    private Long id;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime runDate;
    private char priority;
    private String computerName;
    private ProductionStatusDto productionStatus;
    private Integer transferStatus;
    private Integer includedMachines;
    private MachineCableConfig machineConfig;
    private Integer terminalThreshold;
    private Integer cableThreshold;
    private MachineCableConfig defaultMachineConfig;
    private Integer cableThresholdZ1;
    private Integer cableThresholdZ2;
    private Integer cableThresholdA1;
    private Integer cableThresholdA2;
    private Integer termThresholdZ1;
    private Integer termThresholdZ2;
    private Integer termThresholdA1;
    private Integer termThresholdA2;
    private Integer minLengthZ1;
    private Integer minLengthZ2;
    private Integer minLengthA1;
    private Integer minLengthA2;
    private Integer maxLengthZ1;
    private Integer maxLengthZ2;
    private Integer maxLengthA1;
    private Integer maxLengthA2;
    private Integer bundleOptionsA2;
    private Integer longCircuitOptionsA2;
    private Boolean cableChangeZ1;
    private Boolean cableChangeZ2;
    private Boolean termChangeZ1;
    private Boolean termChangeZ2;
    private Boolean cutAndStripA1;
    private Boolean cutAndStripA2;
    private Boolean cutAndStripZ1;
    private Boolean cutAndStripZ2;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private SortType sortType;
    private Integer brandingColourZ1;
    private Integer brandingColourZ2;
    private Integer brandingColourA1;
    private Integer brandingColourA2;
    private Integer cableThresholdA3;
    private Integer termThresholdA3;
    private Integer minLengthA3;
    private Integer maxLengthA3;
    private Integer cutAndStripA3;
    private Integer brandingColourA3;
    private Set<PlanWorkOrder> workOrders = new HashSet<>();
}
