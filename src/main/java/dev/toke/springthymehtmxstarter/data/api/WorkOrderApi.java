package dev.toke.springthymehtmxstarter.data.api;

import dev.toke.springthymehtmxstarter.data.dto.WorkOrder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.time.LocalDate;
import java.util.List;

public interface WorkOrderApi {
    @GetExchange("http://localhost:8081/work-orders")
    List<WorkOrder> getWorkOrders(@RequestParam(value = "releaseDueDate", required = true) LocalDate releaseDueDate, @RequestParam(value = "status", required = false) String status);
}
