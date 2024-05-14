package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "MaterialComponents")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "componentId")
public class MaterialComponent extends BaseComponent {
    private String supplierPartNumber;
    private Double weightPerUnit;
    private UnitOfMeasurement weightUnit;

    public MaterialComponent(String name, String customerPartNumber,
                             String supplierPartNumber,
                             String description, User createdBy,
                             User updatedBy, UnitOfMeasurement uom,
                             Double weightPerUnit, UnitOfMeasurement weightUnit,
                             ComponentGroup componentGroup
                             ) {
        super(null, name, customerPartNumber, description, createdBy, LocalDateTime.now(),
                updatedBy, LocalDateTime.now(), uom, componentGroup);
        this.supplierPartNumber = supplierPartNumber;
        this.weightUnit = weightUnit;
        this.weightPerUnit = weightPerUnit;

    }
}



