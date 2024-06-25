package dev.toke.springthymehtmxstarter.service.impl;

import dev.toke.springthymehtmxstarter.data.api.WorkOrderApi;
import dev.toke.springthymehtmxstarter.data.dto.WorkOrderDto;
import dev.toke.springthymehtmxstarter.data.dto.WorkOrderWithCircuitCountDto;
import dev.toke.springthymehtmxstarter.service.WorkOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkOrderServiceImpl implements WorkOrderService {
    private final WorkOrderApi workOrderApi;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public List<WorkOrderDto> getWorkOrders(LocalDate releaseDateFrom, String status) {
        return workOrderApi.getWorkOrders(releaseDateFrom.format(formatter), status);
    }

    @Override
    public List<WorkOrderWithCircuitCountDto> getUnplannedWorkOrders(LocalDate releaseDueDate) {
        return workOrderApi.getUnassignedWorkOrdersWithCircuitCount(releaseDueDate.format(formatter));
    }

    @Override
    public List<WorkOrderWithCircuitCountDto> getPlannedWorkOrders(Integer planId) {
        return workOrderApi.getPlannedWorkOrdersByPlanId(planId);
    }


    @Override
    public WorkOrderDto getWorkOrder(long id) {
        return workOrderApi.getWorkOrder(id);
    }
}
