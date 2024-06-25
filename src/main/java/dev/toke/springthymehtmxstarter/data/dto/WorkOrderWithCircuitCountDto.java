package dev.toke.springthymehtmxstarter.data.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkOrderWithCircuitCountDto {
    private Integer id;
    private String partNumber;
    private String revision;
    private String customer;
    private Integer sortTypeId;
    private String status;
    private String firstLocation;
    private LocalDateTime releaseDueOn;
    private LocalDateTime releasedDate;
    private Integer quantity;
    private Integer circuitsPerHarness;
    private Integer totalCircuits;
    private Integer totalTerminations;
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public String releaseDueDateToString() {
        return releaseDueOn.format(formatter);
    }

    public String releasedDateToString() {
        return releasedDate.format(formatter);
    }
}