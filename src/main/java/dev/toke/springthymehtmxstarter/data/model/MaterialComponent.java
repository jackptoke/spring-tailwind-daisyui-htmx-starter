package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.Entity;

@Entity
public class MaterialComponent extends BaseComponent {
    private Double weightPerUnit;
    private UnitOfMaesurement weightUnit;
}
