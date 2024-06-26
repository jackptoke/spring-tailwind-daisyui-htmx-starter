package dev.toke.springthymehtmxstarter.data.api;

import dev.toke.springthymehtmxstarter.data.dto.WorkOrderDto;
import dev.toke.springthymehtmxstarter.data.dto.WorkOrderWithCircuitCountDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.time.LocalDate;
import java.util.List;

public interface WorkOrderApi {
    @GetExchange("/work-orders")
    List<WorkOrderDto> getWorkOrders(@RequestParam(value = "releaseDueDate") String releaseDueDate,
                                     @RequestParam(value = "status", required = false) String status);


    @GetExchange("/work-orders/{workOrderId}")
    WorkOrderDto getWorkOrder(@RequestParam(value = "workOrderId") Long workOrderId);

    @GetExchange("/work-orders/with-circuits")
    List<WorkOrderWithCircuitCountDto> getUnassignedWorkOrdersWithCircuitCount(
            @RequestParam(value = "releaseDueDate") String releaseDueDate
    );

    @GetExchange("/work-orders/planned")
    List<WorkOrderWithCircuitCountDto> getPlannedWorkOrdersByPlanId(@RequestParam(value = "planId") Integer planId);
}
