package dev.toke.springthymehtmxstarter.data.model;

import dev.toke.springthymehtmxstarter.data.model.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BillOfMaterials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillOfMaterial {
    @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billOfMaterialsId;
    private String circuitName;
    private Integer priceCategoryId;
    private String updateUser;
    private LocalDateTime updateTimestamp;
    private String insertUser;
    private LocalDateTime insertTimestamp;
    private Double quantity;
    private UnitOfMeasurement unitOfMeasurement; //[QuantityUnits]

    @ManyToOne
    @JoinColumn(name = "componentTypeId", nullable = false, referencedColumnName = "id")
    private BomComponentType componentType;

    @ManyToOne
    @JoinColumn(name = "amepart_id", referencedColumnName = "id", nullable = true)
    private AmePart bomComponent;

    @ManyToOne
    @JoinColumn(name = "harnessRevision_id", referencedColumnName = "revisionId")
    private HarnessRevision harnessRevision;

//    @ManyToOne
//    @JoinColumn(name = "eng_bom_Ident", referencedColumnName = "Ident")
//    private EngineerBom engineerBom;

    @ManyToOne
    @JoinColumn(name = "engineerInstruction_id", referencedColumnName = "id")
    private EngineerInstruction engineerInstruction;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "circuit_id", referencedColumnName = "id")
    private CableCircuit circuit;

    @OneToOne(mappedBy = "bomComponent", cascade = CascadeType.ALL)
    private CableEnd cableEnd;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private BillOfMaterial parent;

    public BillOfMaterial(String name, HarnessRevision harnessRevision, Double quantity, UnitOfMeasurement uom,
                          AmePart amePart, BomComponentType componentType, Integer priceCategoryId, String user,
                          BillOfMaterial parent) {
        setCircuitName(name);
        setHarnessRevision(harnessRevision);
        setQuantity(quantity);
        setUnitOfMeasurement(uom);
        if(amePart != null) setBomComponent(amePart);
        if(componentType != null) setComponentType(componentType);
        setPriceCategoryId(priceCategoryId);
        setInsertUser(user);
        setUpdateUser(user);
        setInsertTimestamp(LocalDateTime.now());
        setUpdateTimestamp(LocalDateTime.now());
        if(parent != null) setParent(parent);
    }

}
