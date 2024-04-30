package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MaterialComponent extends BaseComponent {
    private Double weightPerUnit;
    private UnitOfMaesurement weightUnit;
}
