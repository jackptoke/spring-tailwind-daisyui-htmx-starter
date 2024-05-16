package dev.toke.springthymehtmxstarter.controller;

import dev.toke.springthymehtmxstarter.data.api.WorkOrderApi;
import dev.toke.springthymehtmxstarter.data.dto.WorkOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/work-orders")
@RequiredArgsConstructor
public class WorkOrderController {
    private final WorkOrderApi workOrderApi;

    @GetMapping
    public String index(Model model) {
        List<WorkOrder> workOrders = workOrderApi.getWorkOrders();
        model.addAttribute("workOrders", workOrders);
        return "workorders/index";
    }
}
