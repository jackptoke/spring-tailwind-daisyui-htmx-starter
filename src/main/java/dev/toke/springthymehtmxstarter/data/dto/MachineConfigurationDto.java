package dev.toke.springthymehtmxstarter.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MachineConfigurationDto {
    private Integer id;
    private Integer cableThreshold;
    private Integer terminalThreshold;
    private Integer sealThreshold;
    private Integer minimumLength;
    private Integer maximumLength;
    private Boolean canChangeCable;
    private Boolean canChangeTerminal;
    private Boolean loopTerminate;
    private Boolean canCutAndStrip;
    private String brandColours;

}
