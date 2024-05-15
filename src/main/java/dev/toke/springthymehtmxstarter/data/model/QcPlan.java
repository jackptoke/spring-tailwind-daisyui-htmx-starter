package dev.toke.springthymehtmxstarter.data.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "QC_PLANS")
@Getter
@Setter
public class QcPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String qcNumber;
    private String qcA;
    private String qcB;
    private String qcC;
    private String qcD;
    private String qcE;
    private String qcF;
    private String qcG;
    private String qcH;
    private String qcI;
    private String qcJ;
    private String qcK;
    private String qcL;
}
