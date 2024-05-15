package dev.toke.springthymehtmxstarter.data.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "EngineerInstructions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EngineerInstruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bomKey;
    private String circuitName;
    private String twistWith;
    private String description;
    private Integer leftCutBack;
    private Integer leftStrip;
    private String leftBeforeTerminating;
    private String leftApplicationCode;
    private String leftBrand;
    private String leftJoin;
    private String leftConnector;
    private String leftTube;
    private String leftMiscellaneous;
    private String leftMold;
    private Integer rightCutBack;
    private Integer rightStrip;
    private String rightBeforeTerminating;
    private String rightApplicationCode;
    private String rightBrand;
    private String rightJoin;
    private String rightConnector;
    private String rightTube;
    private String rightMiscellaneous;
    private String rightMold;
    private String circuitNotes;
    private Integer maxBundleSize;
    private Integer circuitNumber;
    private String circuitAlpha;
    private String itemType;
    private LocalDateTime startOn;
    private LocalDateTime endOn;
    private String visualNumber;
    private Double twistedLength;
    private Double cutLength;
    private String parentHarness;
}
