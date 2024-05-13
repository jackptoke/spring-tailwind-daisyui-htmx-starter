package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseComponent {
    @Id
    private Long id;
    private String partNumber;
    private String customerPartNumber;
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User createdByUser;
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updatedByUser")
    private User updatedBy;
    private LocalDateTime updatedAt;
    private UnitOfMaesurement uom;
}
