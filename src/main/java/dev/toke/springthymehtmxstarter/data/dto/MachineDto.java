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
public class MachineDto {
    private Integer id;
    private String machineName;
    private String machineType;
    private String machineSubType;
    private String serialNumber;
    private String wpcsDataPath;
    private String wpcsFeedbackPath;
    private LocalDateTime insertedDate;
    private String insertedBy;  // user
    private LocalDateTime updatedDate;
    private String updatedBy;
    private Integer bitValue;
    private Boolean isInUse;
    private Integer displayOrder;
    private MachineConfigurationDto configuration;

    public MachineConfigFormData configToFormData() {
        return new MachineConfigFormData(
                    this.id,
                    this.machineName,
                    this.configuration.getCableThreshold(),
                    this.configuration.getTerminalThreshold(),
                    this.configuration.getSealThreshold(),
                    this.configuration.getMinimumLength(),
                    this.configuration.getMaximumLength(),
                    this.configuration.getCanChangeCable(),
                    this.configuration.getCanChangeTerminal(),
                    this.configuration.getLoopTerminate(),
                    this.configuration.getCanCutAndStrip(),
                    this.configuration.getBrandColours()
        );
    }
}
