package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MaterialComponent")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MaterialComponent extends BaseComponent {
    private String supplierPartNumber;
    private Double weightPerUnit;
    private UnitOfMaesurement weightUnit;
}
