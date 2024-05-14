package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Circuits")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Circuit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;  // Circuit name
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cable_id")
    private Cable cable;
    private Double length;
    private Double modifiedLength; // Twisted length
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end1_terminal_id")
    private MaterialComponent end1Terminal = null;
    private Double end1StripLength;
    private Double end1CutbackLength;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end2_terminal_id")
    private MaterialComponent end2Terminal = null;
    private Double end2StripLength;
    private Double end2CutbackLength;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end1_seal_id")
    private MaterialComponent leftSeal = null;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end2_seal_id")
    private MaterialComponent rightSeal = null;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "harness_id")
    private Harness harness;
    @OneToMany(mappedBy = "circuit")
    private Set<CircuitAccessory> accessories;
}
