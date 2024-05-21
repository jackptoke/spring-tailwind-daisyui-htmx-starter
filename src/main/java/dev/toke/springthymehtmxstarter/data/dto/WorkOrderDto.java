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
public class WorkOrderDto {
    private Long id;
    private String partNumber;
    private String revision;
    private String customer;
    private Integer quantity;
    private Boolean isCompleted;
    private String status;
    private String specialCode;
    private String unitOfMaesurement;
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
    private LocalDate dispatchByDate;
    private LocalDate releaseByDate;
    private LocalDate releasedDate;
    private Boolean doNotRelease;




}
/*
        Case "P"
          row.StatusText = "Pending"
        Case "O"
          row.StatusText = "Open"
        Case "R"
          row.StatusText = "Released"
        Case "C"
          row.StatusText = "Closed"
        Case Else
          row.StatusText = "Unknown"
 */
