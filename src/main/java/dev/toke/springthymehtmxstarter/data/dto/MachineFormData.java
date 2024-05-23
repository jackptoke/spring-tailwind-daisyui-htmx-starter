package dev.toke.springthymehtmxstarter.data.dto;


import dev.toke.springthymehtmxstarter.data.model.MachineProperty;
import dev.toke.springthymehtmxstarter.data.model.MachinesProperties;
import dev.toke.springthymehtmxstarter.data.model.PrintColour;
import dev.toke.springthymehtmxstarter.data.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MachineFormData {
    private Integer id;
    @NotBlank
    private String machineName;
    @NotBlank
    private String machineBrand;
    private String machineModel = "";
    private String serialNumber = "";
    private String dataPath = ""; // WPCS folder uri
    private String feedbackPath = ""; // WPCS feedback uri
    private Boolean isActive = true;
    private String user;
//    private Set<MachinesProperties> properties;
}
