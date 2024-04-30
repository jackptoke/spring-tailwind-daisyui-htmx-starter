package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;

@Entity
public class Cable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String wireGroup;
    private Double wireSize; // MM^2
    private Double diameter;
    private String colour;

    @ManyToOne
    @JoinColumn(name = "cabletype_id")
    private CableType cableType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "component_id", referencedColumnName = "id")
    private MaterialComponent materialComponent;
}
