package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cables")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
