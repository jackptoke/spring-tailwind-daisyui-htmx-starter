package dev.toke.springthymehtmxstarter.data.dto.display;

import dev.toke.springthymehtmxstarter.data.dto.MachineCableConfig;
import dev.toke.springthymehtmxstarter.data.dto.ProductionStatusDto;

import java.time.LocalDateTime;

public record PlanDisplay(
        Long id,
        String description,
        String startDate,
        String endDate,
        String runDate,
        char priority,
        String computerName,
        String productionStatus,
        Integer transferStatus,
        String machineConfig,
        Integer numberOfBatches,
        String lastUpdateAt
) {
}
