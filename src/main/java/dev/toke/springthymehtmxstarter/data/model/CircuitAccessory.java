package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CircuitAccessories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CircuitAccessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Double quantity;
    @NotNull
    @Enumerated(EnumType.STRING)
    private UnitOfMeasurement uom;
    private String note = "";
    @NotNull
    @Enumerated(EnumType.STRING)
    private CircuitEndType cableEnd;  // which end of the cable or where on the cable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "circuitId")
    private Circuit circuit;
}
