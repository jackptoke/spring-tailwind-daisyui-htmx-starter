package dev.toke.springthymehtmxstarter.data.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkOrderDetail {
    @Id
    private Long id;
    private String componentName;
    private String revision;
    private Double totalQuantity;
    private Double quantityPer;
    private Double allocatedQuantity;
    private Double pickedQuantity;
    private Double shortQuantity;
    private String uom;
    private Boolean isIssued;
    private LocalDateTime addedAt;
    private Long workOrderId;
    private String workStatus;
    private LocalDateTime pickedAt;
}
