package dev.toke.springthymehtmxstarter.data.api;

import dev.toke.springthymehtmxstarter.data.dto.WorkOrder;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface WorkOrderApi {
    @GetExchange("http://localhost:8081/work-orders?releaseDueDate=2024-05-17&status=O")
    List<WorkOrder> getWorkOrders();
}
