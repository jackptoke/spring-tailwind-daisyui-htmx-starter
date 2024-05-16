package dev.toke.springthymehtmxstarter.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkOrder {
    private Long id;
    private String partNumber;
    private String revision;
    private Integer quantity;
    private Boolean isCompleted;
    private String status;
    private String specialCode;
    private String unitOfMaesurement;
    private String customer;
    private Integer quantityIssued;
    private Boolean plDone;
    private Boolean isUnReleased;
    private Boolean isChild;
    private String workSite;
    private String deliverySite;
    private String deliveryLocation;
    private String notes;
    private String relatedTo;
    private LocalDateTime insertedDate;
    private String insertedByUser;
    private LocalDateTime updatedDate;
    private String updatedByUser;
    private LocalDateTime releasedDate;
    private LocalDate dueDate;
}
