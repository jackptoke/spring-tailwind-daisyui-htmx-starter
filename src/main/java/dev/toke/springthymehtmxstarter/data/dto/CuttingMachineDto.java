package dev.toke.springthymehtmxstarter.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CuttingMachineDto {
    private Integer id;
    private String name;
    private String model;
    private String subModel;
    private String serialNumber;
    private String dataPath;
    private String feedbackPath;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Integer bitValue;
    private Boolean isActive;
    private Integer displayOrder;
}