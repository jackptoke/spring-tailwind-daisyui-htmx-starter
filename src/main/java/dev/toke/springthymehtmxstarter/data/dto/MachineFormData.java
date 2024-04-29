package dev.toke.springthymehtmxstarter.data.dto;


import dev.toke.springthymehtmxstarter.data.model.PrintColour;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MachineFormData {
    private Long id;
    @NotBlank
    private String machineName;
    private String description = "";
    @NotBlank
    private String machineBrand;
    private String machineModel = "";
    private String dataPath = ""; // WPCS folder uri
    private String feedbackPath = ""; // WPCS feedback uri
    private Boolean isActive = true;
    private Integer cableThreshold = 40;
    private Integer termAndSealThreshold = 40;
    private Integer minimumLength = 60;
    private Integer maximumLength = 5000;
    private Boolean canChangeCable = false;
    private Boolean canChangeTerminal = false;
    private Boolean canCutAndStrip = false;
    private String printColour;
}
