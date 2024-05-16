package dev.toke.springthymehtmxstarter.data.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CircuitCableEndDTO {
    private Long cableEndId;

    private String cableEnd;

    private Double cutbackAmount;

    private Double stripAmount;

    private int numberBeforeTerination;

    private String branding;

    private Double brandingDistance;

    private String appCode;

    private String mould;

    private String tube;

    private String join;

    private String connector;

    private String connectorCavity;

    private String updateUser;

    private LocalDateTime updateTimestamp;

    private String insertUser;

    private LocalDateTime insertTimestamp;

}