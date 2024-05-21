package dev.toke.springthymehtmxstarter.service;

import dev.toke.springthymehtmxstarter.data.dto.WorkOrderDto;

import java.time.LocalDate;
import java.util.List;

public interface WorkOrderService {
    List<WorkOrderDto> getWorkOrders(LocalDate releaseDateFrom, String status);
    WorkOrderDto getWorkOrder(long id);
}
