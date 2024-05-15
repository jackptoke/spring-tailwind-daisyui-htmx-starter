package dev.toke.springthymehtmxstarter.data.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "CableEnds")
@Getter
@Setter
@NoArgsConstructor
public class CableEnd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne
    @JoinColumn(name = "bomComponent_id")
    @JsonIgnore
    private au.com.amesystems.amecoreapi.models.BillOfMaterial bomComponent;

    public CableEnd(au.com.amesystems.amecoreapi.models.BillOfMaterial bomComponent, String end, Double cutbackValue, Double stripAmount,
                    Integer numberBeforeTermination, String branding, Double brandingDistance,
                    String appCode, String mould, String tube, String join, String connector,
                    String connectorCavity, String user
    ) {
        setBomComponent(bomComponent);
        setCableEnd(end);
        setCutbackAmount(cutbackValue);
        setStripAmount(stripAmount);
        setNumberBeforeTerination(numberBeforeTermination);
        setBranding(branding);
        setBrandingDistance(brandingDistance);
        setAppCode(appCode);
        setMould(mould);
        setTube(tube);
        setJoin(join);
        setConnector(connector);
        setConnectorCavity(connectorCavity);
        setInsertUser(user);
        setInsertTimestamp(LocalDateTime.now());
        setUpdateUser(user);
        setUpdateTimestamp(LocalDateTime.now());
    }
}