package dev.toke.springthymehtmxstarter.data.model;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "AmePart")
@Getter
@Setter
@NoArgsConstructor
public class AmePart {
    @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partNumber;
    private String description;
    private Boolean partStatus;
    private String supplierPartNumber;
    private String manufacturer;
    private String group;
    private String unitOfMeasurement;
    private String supplier;
    private String currency;
    private String notes;
    private Double weight;
    private String weightUnit;
    private Boolean doNotOrder;
    private String colour;
    private String author;
    private Boolean isUseLot;
    private Boolean isPickedItem;
    private Boolean isIssuedItem;
    private Boolean isPhantom;
    private Boolean isFcOk;
    private Character partCode;
    private String updateUser;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Double stripLength;
    private BigDecimal maxXSize;
    private BigDecimal minXSize;
    private String crimpValueCode;
    private Double orderQuantity;
    private Double minOrder;
    private Double purchaseLeadTime;
    private Double manufactureLeadTime;
    private String policy;
    private Double period;
    private Double safetyQ;
    private Double safetyT;
    private String buyer;
    private String defaultLocation;
    private String pickLocation;
    private BigDecimal minimum;
    private BigDecimal maximum;
    private String defaultSite;
    private String defaultPickSite;
    private String useSite;
    private String useLocation;
    private String hsCode;
    private Boolean isFreeInAid;
    private String basePart;
    private Integer valuationCodeId;
    private Double crossXSectionSize;
    private Integer cableTypeId;

    public AmePart(String partNumber, String group) {
        this.partNumber = partNumber;
        this.group = group;
        partCode = 'P';
        isPickedItem = true;
        partStatus = true;
        isUseLot = false;
        isFcOk = false;
        isIssuedItem = true;
        isPhantom = false;

        orderQuantity = 1.0;
        supplier = "";
        unitOfMeasurement = "EA";
        minOrder = 0.0;
        purchaseLeadTime = 0.0;
        manufactureLeadTime = 0.0;
        policy = "LFL";
        period = 0.0;
        safetyQ = 0.0;
        safetyT = 0.0;
        buyer = "";
        currency = "AUD";
        defaultLocation = "NO-LOC";
        pickLocation = "NO-LOC";
        defaultSite = "ARARAT";
        defaultPickSite = "ARARAT";
        minimum = BigDecimal.valueOf(0.0);
        maximum = BigDecimal.valueOf(0.0);
        crimpValueCode = "";
        crossXSectionSize = 0.0;
        useLocation = "";
        useSite = "";
        supplierPartNumber = "";
        author = "";
        manufacturer = "";
        hsCode = "";
        isFreeInAid = false;
        basePart = "";
        valuationCodeId = 0;
        weightUnit = "";
    }
}