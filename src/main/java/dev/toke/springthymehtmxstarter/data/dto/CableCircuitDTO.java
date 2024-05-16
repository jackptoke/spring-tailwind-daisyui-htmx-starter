package dev.toke.springthymehtmxstarter.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.toke.springthymehtmxstarter.data.model.EngineerInstruction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CableCircuitDTO {
    private Long id;
    private String branding;
    private Double brandingInterval;
    private String cableDescription;
    private Double cutLength;
    private Double twistedLength;
    private String twistWith;
    private int maxBundleSize;
    private String updateUser;
    private LocalDateTime updateTimestamp;
    private String insertUser;
    private LocalDateTime insertStamp;
    private String twistGroup;
    private EngineerInstruction engineerInstruction;
}
