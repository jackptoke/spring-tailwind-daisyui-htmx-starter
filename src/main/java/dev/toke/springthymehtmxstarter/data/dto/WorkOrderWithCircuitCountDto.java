package dev.toke.springthymehtmxstarter.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
}