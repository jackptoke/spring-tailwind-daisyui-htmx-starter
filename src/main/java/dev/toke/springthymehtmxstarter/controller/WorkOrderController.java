package dev.toke.springthymehtmxstarter.controller;

import dev.toke.springthymehtmxstarter.data.api.WorkOrderApi;
import dev.toke.springthymehtmxstarter.data.dto.WorkOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/work-orders")
@RequiredArgsConstructor
public class WorkOrderController {
    private final WorkOrderApi workOrderApi;

    @GetMapping
    public String index(Model model) {
        LocalDate date = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
        List<WorkOrder> workOrders = workOrderApi.getWorkOrders(date, null);
        model.addAttribute("workOrders", workOrders);

        model.addAttribute("OrderIds", workOrders.stream().map(WorkOrder::getId).toList());
        return "workorders/index";
    }
}
