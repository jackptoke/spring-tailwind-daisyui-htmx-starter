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
    private String status;
    private LocalDateTime releaseDueOn;
    private Integer quantity;
    private Integer circuitsPerHarness;
    private Integer totalCircuits;
//    @Setter(AccessLevel.NONE)
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public String releaseDueDateToString() {
        return releaseDueOn.format(formatter);
    }
}