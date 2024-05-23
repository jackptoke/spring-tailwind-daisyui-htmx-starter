package dev.toke.springthymehtmxstarter.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MachineConfigFormData {
    private Integer machineId;
    private String machineName;
    private Integer cableThreshold;
    private Integer terminalThreshold;
    private Integer sealThreshold;
    private Integer minimumLength;
    private Integer maximumLength;
    private Boolean cableChange;
    private Boolean terminalChange;
    private Boolean canLoopTerminate;
    private Boolean cutAndStrip;
    private String brandColour;
}
