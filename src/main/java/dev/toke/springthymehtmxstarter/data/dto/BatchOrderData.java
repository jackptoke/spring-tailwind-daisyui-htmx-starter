package dev.toke.springthymehtmxstarter.data.dto;

import dev.toke.springthymehtmxstarter.data.model.BatchOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BatchOrderData {
    private Long id;
    private String harness;
    private String revision;
    private Integer quantity;
    private Integer circuitCount;
    private Integer terminationCount;
    private String customer;
    private String siteName;
    private String deliverySite;
    private String deliveryLocation;
    private String releaseLocation;
    private String specialCode = "";
    private LocalDate releaseDueDate;
    private LocalDateTime releasedDate;
    private LocalDate dispatchedDate;
    private LocalDateTime insertedDate;
    protected Boolean selected;

    public static BatchOrderData from(BatchOrder batchOrder) {
        return new BatchOrderData(
                batchOrder.getId(),
                batchOrder.getHarness(),
                batchOrder.getRevision(),
                batchOrder.getQuantity(),
                batchOrder.getCircuitCount(),
                batchOrder.getTerminationCount(),
                batchOrder.getCustomer(),
                batchOrder.getSiteName(),
                batchOrder.getDeliverySite(),
                batchOrder.getDeliveryLocation(),
                batchOrder.getReleaseLocation(),
                batchOrder.getSpecialCode(),
                batchOrder.getReleaseDueDate(),
                batchOrder.getReleasedDate(),
                batchOrder.getDispatchedDate(),
                batchOrder.getInsertedDate(),
                false
                );
    }

    public static BatchOrder to(BatchOrderData batchOrder) {
        BatchOrder newBatch = new BatchOrder();
        newBatch.setId(batchOrder.getId());
        newBatch.setHarness(batchOrder.getHarness());
        newBatch.setRevision(batchOrder.getRevision());
        newBatch.setQuantity(batchOrder.getQuantity());
        newBatch.setCircuitCount(batchOrder.getCircuitCount());
        newBatch.setTerminationCount(batchOrder.getTerminationCount());
        newBatch.setCustomer(batchOrder.getCustomer());
        newBatch.setSiteName(batchOrder.getSiteName());
        newBatch.setDeliverySite(batchOrder.getDeliverySite());
        newBatch.setDeliveryLocation(batchOrder.getDeliveryLocation());
        newBatch.setReleaseLocation(batchOrder.getReleaseLocation());
        newBatch.setSpecialCode(batchOrder.getSpecialCode());
        newBatch.setReleaseDueDate(batchOrder.getReleaseDueDate());
        newBatch.setReleasedDate(batchOrder.getReleasedDate());
        newBatch.setDispatchedDate(batchOrder.getDispatchedDate());
        newBatch.setInsertedDate(batchOrder.getInsertedDate());
        return newBatch;
    }
}
