package dev.toke.springthymehtmxstarter.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "BatchOrder")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BatchOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String harness;
    @NotBlank
    private String revision;
    @NotNull
    private Integer quantity;
    private Integer circuitCount;
    private Integer terminationCount;
    @NotBlank
    private String customer;
    @NotBlank
    private String siteName;
    @NotBlank
    private String deliverySite;
    @NotBlank
    private String deliveryLocation;
    @NotBlank
    private String releaseLocation;
    private String specialCode = "";
    private LocalDateTime plDone;
    private LocalDate releaseDueDate;
    private LocalDateTime releasedDate;
    private LocalDate dispatchedDate;
    private LocalDateTime insertedDate;
    private LocalDateTime updatedDate;
    private String insertedBy;
    private String updatedBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workplan_id")
    private WorkPlan workPlan;
}
