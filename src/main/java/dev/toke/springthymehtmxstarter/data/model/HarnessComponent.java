package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HarnessComponents")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HarnessComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "harness_id")
    private Harness harness;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "component_id")
    private MaterialComponent component;
    private Double quantity;
    private UnitOfMeasurement uom;
}
