package dev.toke.springthymehtmxstarter.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "CableCircuits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CableCircuit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    @JoinColumn(name = "engineerInsturction_id", referencedColumnName = "id")
    private EngineerInstruction engineerInstruction;

//    @Column(name = "BillOfMaterialsID")
//    private Long billOfMaterialId;

    @OneToOne
    @JoinColumn(name = "billOfMaterial_id")
    @JsonIgnore
    private BillOfMaterial bomComponent;

    public CableCircuit(BillOfMaterial bom, String branding, Double brandingInterval, String cableDescription,
                   Double cutLength, String twistWith, Double twistedLength, Integer maxBundleSize, String user) {
        setBomComponent(bom);
        setBranding(branding);
        setBrandingInterval(brandingInterval);
        setCableDescription(cableDescription);
        setCutLength(cutLength);
        setTwistWith(twistWith);
        setTwistedLength(twistedLength);
        setMaxBundleSize(maxBundleSize);
        setUpdateUser(user);
        setUpdateTimestamp(LocalDateTime.now());
        setInsertUser(user);
        setInsertStamp(LocalDateTime.now());
        setEngineerInstruction(null);
    }

}
