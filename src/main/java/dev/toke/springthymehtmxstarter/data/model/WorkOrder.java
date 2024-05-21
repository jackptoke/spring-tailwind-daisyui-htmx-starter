package dev.toke.springthymehtmxstarter.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkOrder {
    private Integer id;
    private BigDecimal quantity;
    private LocalDate releasedDate;
    private LocalDate dispatchByDate;
    private LocalDateTime releaseByDate;
    private Boolean isCompleted;
    private String status;
    private String specialCode;
    private String unitOfMaesurement;
    private String customer;
    private BigDecimal quantityIssued;
    private LocalDateTime plDone;
    private String workSite;
    private String deliverySite;
    private String deliveryLocation;
    private String notes;
    private String relatedTo;
    private LocalDateTime insertedDate;
    private String insertedByUser;
    private LocalDateTime updatedDate;
    private String updatedByUser;
    private Boolean isUnReleased;
    private Boolean isChild;
    private HarnessRevision harnessRevision;
}
