package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.dto.WorkOrderDto;
import dev.toke.springthymehtmxstarter.data.dto.WorkOrderWithCircuitCountDto;

import java.time.LocalDate;
import java.util.List;

public interface WorkOrderService {
    List<WorkOrderDto> getWorkOrders(LocalDate releaseDateFrom, String status);
    List<WorkOrderWithCircuitCountDto> getUnplannedWorkOrders(LocalDate releaseDueDate);
    WorkOrderDto getWorkOrder(long id);
}
